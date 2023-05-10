FROM openjdk:17-jdk

WORKDIR /app

COPY target/security_app-0.0.1-SNAPSHOT.jar /app/security_app.jar

EXPOSE 8080

CMD ["java", "-jar", "security_app.jar"]



