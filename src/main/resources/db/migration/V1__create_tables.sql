-- V1__create_tables.sql

CREATE TABLE cliente (
                         id SERIAL PRIMARY KEY,
                         nome VARCHAR(255) NOT NULL,
                         tipo_cliente VARCHAR(50) NOT NULL
);

CREATE TABLE pato (
                      id SERIAL PRIMARY KEY,
                      nome VARCHAR(255) NOT NULL,
                      raca VARCHAR(100),
                      idade INT,
                      sexo VARCHAR(10),
                      status VARCHAR(20),
                      id_mae INT,
                      FOREIGN KEY (id_mae) REFERENCES pato(id)
);