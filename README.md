# API de Gestión de Clientes

Esta es una API RESTful desarrollada en Java Spring Boot para la gestión de clientes, aplicando principios de Clean Architecture y buenas prácticas.

## Requisitos Previos
- Java 17
- Maven
- MySQL

## Documentación de la API
Una vez iniciada la aplicación, la documentación interactiva (Swagger UI) está disponible en:
`http://localhost:8080/swagger-ui.html`

## Script de Base de Datos Inicial

Ejecuta el siguiente script en tu motor MySQL antes de iniciar la aplicación por primera vez:

```sql
CREATE DATABASE IF NOT EXISTS clientes_db;
USE clientes_db;

CREATE TABLE IF NOT EXISTS clientes (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    apellido VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    create_at DATETIME
);

INSERT INTO clientes (nombre, apellido, email, create_at) VALUES 
('Carlos', 'Gomez', 'carlos.gomez@email.com', NOW()),
('Maria', 'Rodriguez', 'maria.rodriguez@email.com', NOW()),
('Andres', 'Lopez', 'andres.lopez@email.com', NOW());
