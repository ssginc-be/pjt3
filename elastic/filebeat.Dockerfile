ARG VERSION
FROM elastic/filebeat:${VERSION}
COPY filebeat.yml /usr/share/filebeat/filebeat.yml
USER root
RUN chown -R root /usr/share/filebeat/logs