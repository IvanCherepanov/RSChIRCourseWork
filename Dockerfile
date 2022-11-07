FROM openjdk:11
EXPOSE 8080
ADD RSChIRCourseWork-0.0.1-SNAPSHOT.jar RSChIRCourseWork-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","RSChIRCourseWork-0.0.1-SNAPSHOT.jar"]