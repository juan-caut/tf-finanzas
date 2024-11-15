FROM amazoncorretto:17-alpine
MAINTAINER ESMERALDA
COPY target/giftService-0.0.1-SNAPSHOT.jar TF-FinanzasServiceBackend.jar
ENTRYPOINT ["java", "-jar", "/TF-FinanzasServiceBackend.jar"]



