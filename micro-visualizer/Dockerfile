FROM amazoncorretto:17-alpine
COPY ./build/libs/micro-visualizer-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8084
ENTRYPOINT ["java","-jar", "/app.jar"]