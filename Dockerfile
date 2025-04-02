FROM openjdk:17-jdk-slim
ARG ${JAR_FILE}=target/serviciosEscuela-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} serviciosEscuela.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/${serviciosEscuela-0.0.1-SNAPSHOT.jar}"]