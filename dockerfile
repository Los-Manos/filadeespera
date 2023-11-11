# Use uma imagem base com o Java e maven
FROM maven:3.8.5-openjdk-17 as build
RUN mkdir -p /usr/src/app
# Define o diretório de trabalho dentro do contêiner
WORKDIR  /usr/src/app
ADD . /usr/src/app
RUN mvn clean package

FROM eclipse-temurin:17-jdk
RUN mkdir -p /usr/src/app
WORKDIR  /usr/src/app
COPY --from=build /usr/src/app/target/filadeespera-0.0.1-SNAPSHOT.jar  app.jar

# Comando para executar a aplicação Java
CMD ["java", "-jar", "app.jar"]