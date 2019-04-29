FROM openjdk:8-jdk-alpine
COPY ./build/libs/brotherhood-0.0.1-SNAPSHOT.jar /usr/src/hola/
WORKDIR /usr/src/hola
EXPOSE 8080
CMD ["java", "-Dspring.data.mongodb.uri=mongodb://mongo:27017/mongo", "-jar", "brotherhood-0.0.1-SNAPSHOT.jar"]