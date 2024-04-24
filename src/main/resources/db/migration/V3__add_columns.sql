-- Adicionar coluna 'data_nascimento' à tabela 'pato'
ALTER TABLE pato
    ADD data_nascimento DATE;

-- Adicionar coluna 'telefone' à tabela 'cliente'
ALTER TABLE cliente
    ADD telefone VARCHAR(20);
