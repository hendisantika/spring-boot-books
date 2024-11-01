FROM gradle:jdk22 as build

LABEL authors="hendisantika"
# Copy the Gradle project into the image
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src

# Build the application without running tests
RUN gradle build --no-daemon -x test || ./gradlew build --no-daemon -x test

# Use Amazon Corretto image for the runtime
FROM amazoncorretto:22

# Copy the built JAR from the build stage
WORKDIR /app
COPY --from=build /home/gradle/src/build/libs/*.jar app.jar

# Run the application
CMD ["java", "-jar", "app.jar"]
