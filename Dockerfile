# Build stage
FROM gradle:8.7-jdk17 as builder
WORKDIR /app
COPY . .
RUN gradle bootJar --no-daemon

# Runtime stage
FROM eclipse-temurin:17-jre
WORKDIR /app
ENV PORT=8080
EXPOSE 8080
COPY --from=builder /app/build/libs/*.jar app.jar
ENTRYPOINT ["java","-jar","/app/app.jar"]
