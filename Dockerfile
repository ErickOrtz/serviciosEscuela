# Fase de construcción
FROM openjdk:17.0.1-jdk AS builder
WORKDIR /app
RUN apt-get update && apt-get install -y maven  
COPY pom.xml .
COPY src ./src
RUN mvn package -DskipTests

# Fase de ejecución
FROM openjdk:17.0.1-jdk-slim  
EXPOSE 8080
COPY --from=builder /app/target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]