ARG VERSION
FROM elasticsearch:${VERSION}
RUN elasticsearch-plugin install analysis-nori

USER root
RUN chmod 775 /usr/share/elasticsearch/data
RUN chown -R elasticsearch:elasticsearch /usr/share/elasticsearch/data
USER elasticsearch