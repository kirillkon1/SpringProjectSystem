# Лёгкое окружение с JDK 17
FROM openjdk:17-jdk-slim
LABEL name="user-manager-service"

WORKDIR /app

# Копируем файл сборки
COPY build/libs/UserManagementService-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java","-jar","/app/app.jar"]