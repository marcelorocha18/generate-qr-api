FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY target/generate-qr-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 9496

ENTRYPOINT ["java","-jar","app.jar"]
