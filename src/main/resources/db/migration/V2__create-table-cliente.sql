CREATE TABLE cliente (
    id_cliente UUID PRIMARY KEY,
    nome_completo VARCHAR(255) NOT NULL,
    sexo VARCHAR(10) NOT NULL,
    data_nascimento DATE NOT NULL,
    cpf VARCHAR(14) UNIQUE NOT NULL,
    aceita_termos BOOLEAN NOT NULL,
    data_hora_do_cadastro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    data_hora_da_ultima_alteracao TIMESTAMP,
    whatssap VARCHAR(20) NOT NULL,
    telefone VARCHAR(20),
    email VARCHAR(255) UNIQUE NOT NULL
);
