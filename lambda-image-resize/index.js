const AWS = require('aws-sdk');
const sharp = require('sharp');
const s3 = new AWS.S3();

exports.handler = async (event, context, callback) => {
    const bucket = event.Records[0].s3.bucket.name;
    const key = decodeURIComponent(event.Records[0].s3.object.key.replace(/\+/g, ' '));
    console.log(`* * * bucket: ${bucket} / key: ${key}`);

    // 지원 파일 확장자가 아닌 경우
    const fileType = key.split('.').pop().toLowerCase();
    let formatType = '';
    console.log(`* * * fileType: ${fileType}`);

    if (fileType !== 'jpg' && fileType !== 'jpeg' && fileType !== 'png') {
        console.log(`Unsupported file type: ${fileType}`);
        return;
    }
    else {
        if (fileType === 'jpg' || fileType === 'jpeg') formatType = 'jpeg';
        else if (fileType === 'png') formatType = 'png';
    }
    console.log(`* * * formatType: ${formatType}`);

    // 원본 이미지 호출, 리사이징
    const originalImage = await s3.getObject({ Bucket: bucket, Key: key }).promise();
    let resizedImage;
    try {
        resizedImage = await sharp(originalImage.Body)
            .resize(400, 400, {fit: 'inside'})
            .toFormat(formatType)
            .toBuffer();
    } catch (error) {
        console.log(error);
        return;
    }
    
    // 결과 파일 저장
    const newKey = key.replace('original/', 'resize/');
    try {
        await s3.putObject({
            Bucket: bucket,
            Key: newKey,
            Body: resizedImage,
            ContentType: 'image/' + formatType
        }).promise();
    } catch(error) {
        console.log(error);
        return;
    }
    
    console.log(`Successfully Image resized and uploaded to: ${newKey}`);
};