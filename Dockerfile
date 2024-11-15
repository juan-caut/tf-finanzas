FROM amazoncorreto:17-alpine-jdk
MAINTAINER ESMERALDA
COPY tarjet/giftService-0.0.1-SNAPSHOT.jar TF-FinanzasServiceBackend.jar
ENTRYPOINT ["java", "-jar", "/TF-FinanzasServiceBackend.jar"]



