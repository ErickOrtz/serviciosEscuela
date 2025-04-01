FROM container-registry.oracle.com/java/jdk:17.0.1
WORKDIR /app
COPY . .
RUN ./mvnw package -DskipTests  # Usa el Maven Wrapper
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "target/your-app.jar"]