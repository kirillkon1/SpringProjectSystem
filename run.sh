#!/bin/bash

# Завершаем скрипт при любой ошибке
set -e

# Task Manager Service
cd TaskManagementService
./gradlew clean build
cd ..

# Task Manager Service
cd ProjectManagementService
./gradlew clean build
cd ..

# Остановка текущих контейнеров Docker
docker-compose down

# Сборка Docker образов без использования кэша
docker-compose build --no-cache task-manager-service project-manager-service

# Запуск контейнеров Docker в фоновом режиме
docker-compose up -d

echo "=== Развертывание завершено успешно ==="
