FROM gradle:jdk11-alpine AS build
WORKDIR /home
COPY gradle /gradle
COPY build.gradle.kts .
COPY settings.gradle.kts .
COPY src /home/src
RUN gradle build -x test --no-daemon

FROM openjdk:11-jre-slim
RUN mkdir /app
COPY --from=build /home/build/libs/plantation-back-1.0.jar /app/plantation-back.jar
EXPOSE 8081
CMD ["java", "-jar", "/app/plantation-back.jar"]
