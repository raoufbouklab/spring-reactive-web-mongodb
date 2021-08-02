FROM openjdk:11

VOLUME /tmp

EXPOSE 8082

ADD target/spring-reactive-web-mongodb.jar spring-reactive-web-mongodb.jar

ENTRYPOINT ["java", "-Dspring.data.mongodb.uri=mongodb://mongo:27017/books", "-jar", "spring-reactive-web-mongodb.jar"]