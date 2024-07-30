Enter fFROM openjdk:17-jdk-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file from the host to the container
COPY  examserver-0.0.1-SNAPSHOT.jar  /app/app.jar

# Specify the command to run the application
ENTRYPOINT ["java", "-jar", "/app/app.jar"]

~
~
~
~
~
~
~
~
~
~
~
~
"Dockerfile" 11L, 283C  ile contents here
