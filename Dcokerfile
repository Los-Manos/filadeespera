FROM maven:3.8.5-openjdk-17 as builder
RUN mkdir -p /app
WORKDIR  /app
COPY pom.xml . 
COPY src ./src
RUN mvn clean install

FROM eclipse-temurin:17-jdk
RUN mkdir -p /usr/src/app
WORKDIR /app
COPY --from=builder /app/target/filadeespera-0.0.1-SNAPSHOT.jar .  

CMD ["java", "-jar", "filadeespera-0.0.1-SNAPSHOT.jar"]