FROM openjdk:17-ea-11-jdk-slim

VOLUME /tmp

COPY target/api-gateway-1.0.jar ApigatewayService.jar

ENTRYPOINT ["java", "-jar", "ApigatewayService.jar"]
