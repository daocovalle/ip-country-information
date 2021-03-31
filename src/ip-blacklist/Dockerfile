FROM amazoncorretto:11-alpine

RUN apk update && apk upgrade --no-cache && apk add --no-cache tzdata

WORKDIR /opt/mercadolibre

COPY build/libs/ip-blacklist*.jar ip-blacklist.jar

ENTRYPOINT exec java $JAVA_OPTS -jar ip-blacklist.jar
