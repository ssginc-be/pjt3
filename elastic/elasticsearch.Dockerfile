ARG VERSION
FROM elasticsearch:${VERSION}
RUN elasticsearch-plugin install analysis-nori