/**
 * Author:  Aluno
 * Created: 22 de ago. de 2024
 */

CREATE DATABASE ifpr;

USE ifpr;

CREATE TABLE IF NOT EXISTS categoria (
    id INT NOT NULL AUTO_INCREMENT,
    descricao VARCHAR(45) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS produto (
    id INT NOT NULL AUTO_INCREMENT,
    descricao VARCHAR(45) NOT NULL,
    categoria_id INT NOT NULL,
    FOREIGN KEY (categoria_id) REFERENCES categoria(id),
    PRIMARY KEY (id)
);