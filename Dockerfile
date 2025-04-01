# Fase de construcción
FROM maven:3.8.6-openjdk-21 as builder
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn package

# Fase de ejecución
FROM openjdk:21-jdk-slim
EXPOSE 8080
COPY --from=builder /app/target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]