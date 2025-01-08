FROM openjdk:21
LABEL name="user-manager-service"

WORKDIR /app

# Копируем файл сборки
COPY build/libs/UserManagementService-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java","-jar","/app/app.jar"]