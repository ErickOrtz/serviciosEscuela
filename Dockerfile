# Fase de construcción (Maven + JDK 17)
FROM maven:3.8.6-openjdk-17 AS builder
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn package -DskipTests

# Fase de ejecución (Solo JAR + JDK 17)
FROM openjdk:17-jdk-slim
EXPOSE 8080
# Copia el JAR específico (usa el nombre exacto o el patrón correcto)
COPY --from=builder /app/target/serviciosEscuela-*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]