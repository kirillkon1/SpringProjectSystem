FROM openjdk:21
LABEL name="analytics-service"

# Устанавливаем рабочую директорию
WORKDIR /app

# Копируем файл сборки
COPY build/libs/AnalyticsService-0.0.1-SNAPSHOT.jar app.jar

# Запускаем приложение
ENTRYPOINT ["java","-jar","/app/app.jar"]