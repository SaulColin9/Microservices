FROM amazoncorretto:17-alpine
COPY ./build/libs/micro-sender-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar", "-Dspring.profiles.active=docker", "/app.jar"]