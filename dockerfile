# Use uma imagem base com o Java
FROM adoptopenjdk:17-jre-hotspot

# Define o diretório de trabalho dentro do contêiner
WORKDIR /src

# Copia o arquivo JAR do seu projeto para o contêiner
COPY target/ms-filadeespera.jar /src/ms-filadeespera.jar

# Comando para executar a aplicação Java
CMD ["java", "-jar", "ms-filadeespera.jar"]