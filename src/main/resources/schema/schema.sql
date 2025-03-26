CREATE DATABASE IF NOT EXISTS crud_personas;
USE crud_personas;

CREATE TABLE IF NOT EXISTS persona (
                                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                       nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    correo VARCHAR(150) NOT NULL UNIQUE
    );