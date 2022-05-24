FROM adoptopenjdk/openjdk11

ARG JAR_FILE_PATH=/build/libs/monitoring-0.0.1-SNAPSHOT.jar

COPY ${JAR_FILE_PATH} app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
