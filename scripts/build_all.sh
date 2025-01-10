#!/bin/bash

# Завершаем скрипт при любой ошибке
set -e

cd ..

# Task Management Service
cd ./TaskManagementService
./gradlew clean build -x test
cd ..

# Project Management Service
cd ./ProjectManagementService
./gradlew clean build -x test
cd ..

# User Management Service
cd ./UserManagementService
./gradlew clean build -x test
cd ..

# API Gateway
cd ./AnalyticsService
./gradlew clean build -x test
cd ..

# Cloud Config Server
cd ./CloudConfig
./gradlew clean build -x test
cd ..

# API Gateway
cd ./ApiGateway
./gradlew clean build -x test
cd ..
