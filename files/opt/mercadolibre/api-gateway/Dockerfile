FROM amazoncorretto:11-alpine

RUN apk update && apk upgrade --no-cache && apk add --no-cache tzdata

WORKDIR /opt/mercadolibre

COPY build/libs/api-gateway*.jar api-gateway.jar

ENTRYPOINT exec java $JAVA_OPTS -jar api-gateway.jar
