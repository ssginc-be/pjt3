FROM openjdk:17-jdk-slim
ARG JAR_FILE=reserve-service/build/libs/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT [ \
    "java", \
    "-jar", \
    "/app.jar", \
    "-web -webAllowOthers -tcp -tcpAllowOthers -browser -ifNotExists" \
]