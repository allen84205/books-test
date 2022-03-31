FROM openjdk:17-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} books.jar
ENTRYPOINT ["java","-jar","/books.jar"]