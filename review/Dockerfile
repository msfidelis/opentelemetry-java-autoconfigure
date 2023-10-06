FROM maven:3.8.3-jdk-11-slim AS build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src src
RUN mvn clean package