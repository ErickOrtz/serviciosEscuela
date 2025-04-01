FROM ubuntu:22.04 AS build
RUN apt-get update && \
    apt-get install -y wget unzip && \
    wget https://github.com/adoptium/temurin17-binaries/releases/download/jdk-17.0.7%2B7/OpenJDK17U-jdk_x64_linux_hotspot_17.0.7_7.tar.gz && \
    tar -xzf OpenJDK17U-jdk_x64_linux_hotspot_17.0.7_7.tar.gz -C /opt && \
    export JAVA_HOME=/opt/jdk-17.0.7+7 && \
    export PATH=$JAVA_HOME/bin:$PATH

WORKDIR /app
COPY . .
RUN ./gradlew build --no-daemon  # Usa el wrapper de Gradle

FROM eclipse-temurin:17-jre-jammy
EXPOSE 8080
COPY --from=build /app/target/serviciosEscuela-*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
