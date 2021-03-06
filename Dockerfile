FROM openjdk:14
LABEL responsable="lucasvannier@gmail.com"
EXPOSE 8080:8080
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} apigateway.jar
ENTRYPOINT ["java","-jar","/apigateway.jar"]