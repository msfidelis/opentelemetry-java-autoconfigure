FROM openjdk:21-jdk

WORKDIR /app

COPY .mvn .mvn
COPY mvnw .
COPY pom.xml .
COPY src src

RUN ./mvnw clean package


# ADD OTEL Java Agent
ADD https://github.com/open-telemetry/opentelemetry-java-instrumentation/releases/latest/download/opentelemetry-javaagent.jar opentelemetry-javaagent.jar

ENV JAVA_TOOL_OPTIONS="-javaagent:./opentelemetry-javaagent.jar"

RUN mv target/*.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]