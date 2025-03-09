# Use uma imagem base com JDK 23
FROM maven:3.8-openjdk-17 AS build
# Define o diretório de trabalho dentro do container
WORKDIR /app

# Copia o arquivo pom.xml para o diretório de trabalho
COPY pom.xml .

# Baixa as dependências do projeto (isso é armazenado em cache para builds futuros)
RUN mvn dependency:go-offline

# Copia o código-fonte para o diretório de trabalho
COPY src ./src

# Compila o projeto e gera o arquivo JAR
RUN mvn package -DskipTests

# Use uma imagem base leve com o JRE instalado
FROM eclipse-temurin:17

# Define o diretório de trabalho dentro do container
WORKDIR /app

# Copia o arquivo JAR gerado na etapa anterior para o diretório de trabalho
COPY --from=build /app/target/expensetracker-0.0.1-SNAPSHOT.jar ./app.jar

# Expõe a porta que a aplicação Spring Boot vai rodar (ajuste conforme necessário)
EXPOSE 8080

# Comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]