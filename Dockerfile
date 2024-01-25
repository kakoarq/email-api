# Use the official OpenJDK 17 base image
FROM openjdk:17-jdk-alpine

# Set the working directory in the container
WORKDIR /app

# Copy the source code into the container
COPY . /app

# Build the application
RUN ./mvnw package -DskipTests

# Expose the port that your Spring Boot app will run on
EXPOSE 8080

# Define the command to run your application
CMD ["java", "-jar", "target/email-api-0.0.1-SNAPSHOT.jar"]