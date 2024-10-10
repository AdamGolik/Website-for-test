
# Use the official OpenJDK image as the base image
FROM openjdk:17-jdk-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the build artifact
COPY target/*.jar app.jar

# Set the startup command to run the jar
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
# Ensure that the target directory exists and contains the build artifact
COPY ./target/*.jar /app/app.jar