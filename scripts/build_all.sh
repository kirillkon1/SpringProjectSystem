#!/bin/bash

# Завершаем скрипт при любой ошибке
set -e

# Task Management Service
echo "Building TaskManagementService..."
cd ../TaskManagementService
./gradlew clean build -x test


# Project Management Service
echo "Building ProjectManagementService..."
cd ../ProjectManagementService
./gradlew clean build -x test


# User Management Service
echo "Building UserManagementService..."
cd ../UserManagementService
./gradlew clean build -x test


# API Gateway
echo "Building AnalyticsService..."
cd ../AnalyticsService
./gradlew clean build -x test


# Cloud Config Server
echo "Building CloudConfig..."
cd ../CloudConfig
./gradlew clean build -x test


# API Gateway
echo "Building ApiGateway..."
cd ../ApiGateway
./gradlew clean build -x test

