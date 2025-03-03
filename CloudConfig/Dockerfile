# Лёгкое окружение с JDK 17
FROM openjdk:17-jdk-slim
LABEL name="config-server"

# Устанавливаем рабочую директорию
WORKDIR /app

# Копируем файл сборки
COPY build/libs/CloudConfig-0.0.1-SNAPSHOT.jar app.jar

# Запускаем приложение
ENTRYPOINT ["java","-jar","/app/app.jar"]