FROM openjdk:17-jdk-slim 
WORKDIR app
COPY target/liberedu-0.0.1-SNAPSHOT.jar /app/liberedu-0.0.1-SNAPSHOT.jar
EXPOSE 8080
CMD ["java", "-jar", "liberedu-0.0.1-SNAPSHOT.jar"]


