FROM maven:3.6.3-jdk-11 AS MAVEN_TOOL_CHAIN
COPY pom.xml /tmp/
COPY api /tmp/api/
COPY domain /tmp/domain/
WORKDIR /tmp/
RUN mvn clean install -Pdocker

FROM adoptopenjdk/openjdk11:alpine-slim
COPY --from=MAVEN_TOOL_CHAIN /tmp/api/target/broccoli-tinder.jar app.jar

RUN sh -c 'touch /app.jar'

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
