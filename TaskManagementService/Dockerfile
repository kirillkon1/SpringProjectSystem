# Лёгкое Alpine-окружение с JRE 21
FROM eclipse-temurin:21-jre-alpine
LABEL name="task-manager-service"

# Устанавливаем рабочую директорию
WORKDIR /app

# Копируем файл сборки
COPY build/libs/TaskManagementService-0.0.1-SNAPSHOT.jar app.jar

# Запускаем приложение
ENTRYPOINT ["java","-jar","/app/app.jar"]