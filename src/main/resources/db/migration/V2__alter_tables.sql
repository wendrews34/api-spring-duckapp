-- Adicionar coluna 'preco' à tabela 'pato'
ALTER TABLE pato
    ADD preco DECIMAL(10, 2);

-- Adicionar coluna 'desconto' à tabela 'cliente'
ALTER TABLE cliente
    ADD desconto DECIMAL(5, 2) DEFAULT 0.0;
