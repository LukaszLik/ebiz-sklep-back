FROM azul/zulu-openjdk:11
ARG APP_FILE=target/*.zip
COPY $APP_FILE app.zip
RUN apt-get update && apt-get install zip unzip
RUN unzip app.zip -d app
EXPOSE 9000
CMD ["./app/sklep_play-1.0-SNAPSHOT/bin/sklep_play"]

