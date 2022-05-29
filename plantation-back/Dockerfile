FROM gradle:jdk11-alpine AS build
COPY gradle /home/gradle
COPY build.gradle.kts /home
COPY settings.gradle.kts /home
COPY src /home/src
WORKDIR /home
RUN gradle build -x test --no-daemon

FROM openjdk:11-jre-slim
RUN mkdir /app
COPY --from=build /home/build/libs/plantation-back-1.0.jar /app/plantation-back.jar
EXPOSE 8081
CMD ["java", "-jar", "/app/plantation-back.jar"]