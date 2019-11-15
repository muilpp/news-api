FROM openjdk:8u131-jdk-alpine
WORKDIR /usr/src/myapp
COPY maven/NEWS_API-MAVEN-0.0.1-SNAPSHOT.jar /usr/src/myapp
EXPOSE 8090
CMD exec java -jar NEWS_API-MAVEN-0.0.1-SNAPSHOT.jar
