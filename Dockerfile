FROM openjdk:17

ARG JAR_FILE=./target/*.jar

EXPOSE 8080

COPY ${JAR_FILE} cliente-pet.jar

ENTRYPOINT ["java", "-jar", "cliente-pet.jar"]