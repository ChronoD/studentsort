# Build stage
FROM maven:3.8.3-openjdk-17 AS build_back
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package


# Package stage
FROM openjdk:17-alpine
COPY --from=build_back /home/app/target/studentsort-0.0.1-SNAPSHOT.jar /usr/local/lib/studentsort.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/local/lib/studentsort.jar"]