-- Criar tabela 'venda'
CREATE TABLE venda (
                       id SERIAL PRIMARY KEY,
                       id_cliente INT NOT NULL,
                       id_pato INT NOT NULL,
                       preco_venda DECIMAL(10, 2),
                       data_venda TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                       FOREIGN KEY (id_cliente) REFERENCES cliente(id),
                       FOREIGN KEY (id_pato) REFERENCES pato(id)
);
