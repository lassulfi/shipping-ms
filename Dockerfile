FROM maven:3.8.2-openjdk-17-slim AS build

WORKDIR /home/app

COPY src /home/app/src

COPY pom.xml /home/app

RUN mvn clean package

FROM openjdk:17-alpine

COPY --from=build /home/app/target/ms-shipping-1.0.0.jar /usr/local/lib/ms-shipping.jar

EXPOSE 8080

ENTRYPOINT [ "java", "-jar", "/usr/local/lib/ms-shipping.jar" ]