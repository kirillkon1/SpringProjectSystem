# Лёгкое окружение с JDK 17
FROM openjdk:17-jdk-slim
LABEL name="project-manager-service"

# Устанавливаем рабочую директорию
WORKDIR /app

# Копируем файл сборки
COPY build/libs/ProjectManagementService-0.0.1-SNAPSHOT.jar app.jar

# Запускаем приложение
ENTRYPOINT ["java","-jar","/app/app.jar"]