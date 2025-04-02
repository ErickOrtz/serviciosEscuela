# Usa una imagen con OpenJDK
FROM eclipse-temurin:17-jdk-alpine

# Directorio de trabajo
WORKDIR /serviciosEscuela

# Copia el JAR construido
COPY target/serviciosEscuela-0.0.1-SNAPSHOT.jar app.jar

# Puerto expuesto (debe coincidir con server.port)
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]