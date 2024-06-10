FROM maven:3.9.7-amazoncorretto-21 AS build

WORKDIR /

COPY . .

RUN mvn clean package -DskipTests

FROM openjdk:21-jdk

WORKDIR /

COPY --from=build /target/*.jar ./uDiscovery.jar

EXPOSE 8761

ENTRYPOINT ["java", "-jar", "./uDiscovery.jar"]
