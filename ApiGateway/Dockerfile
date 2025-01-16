# Лёгкое Alpine-окружение с JRE 21
FROM eclipse-temurin:21-jre-alpine
LABEL name="api-gateway"

WORKDIR /app

COPY build/libs/ApiGateway-0.0.1-SNAPSHOT.jar app.jar

# Запускаем приложение
ENTRYPOINT ["java","-jar","/app/app.jar"]