FROM amazoncorretto:11-alpine

RUN apk update && apk upgrade --no-cache && apk add --no-cache tzdata

WORKDIR /opt/mercadolibre

COPY build/libs/ip-information*.jar ip-information.jar

ENTRYPOINT exec java $JAVA_OPTS -jar ip-information.jar
