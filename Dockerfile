
# Fase de construcción con Gradle y JDK 17
FROM gradle:7.6.1-jdk17 AS build
WORKDIR /app

# 1. Copia SOLO los archivos necesarios para Gradle (evita copiar carpetas innecesarias)
COPY gradlew .
COPY gradle/wrapper/ gradle/wrapper/
COPY build.gradle .
COPY settings.gradle .
COPY src ./src

# 2. Dale permisos de ejecución al wrapper (solo en Linux/macOS)
RUN chmod +x gradlew

# 3. Construye el proyecto
RUN ./gradlew build --no-daemon

# Fase de ejecución (imagen ligera)
FROM eclipse-temurin:17-jre-jammy
EXPOSE 8080
COPY --from=build /app/target/serviciosEscuela-*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]