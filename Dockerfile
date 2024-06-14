FROM openjdk:17-jdk-slim 
WORKDIR .
COPY ./target/liberedu-0.0.1-SNAPSHOT.jar .
EXPOSE 8080
CMD ["java", "-jar", "liberedu-0.0.1-SNAPSHOT.jar"]


