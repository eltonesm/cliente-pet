CREATE TABLE pet (
    id_pet UUID PRIMARY KEY,
    id_cliente_tutor UUID ,
    nome_pet VARCHAR(255) NOT NULL,
    porte VARCHAR(50),
    tipo_pet VARCHAR(50) NOT NULL,
    microchip VARCHAR(255),
    raca VARCHAR(255) NOT NULL,
    sexo_pet VARCHAR(20) NOT NULL,
    pelagem_cor VARCHAR(255),
    data_nascimento DATE NOT NULL,
    rga VARCHAR(50),
    peso INT,
    data_hora_do_cadastro TIMESTAMP,
    data_hora_da_ultima_alteracao TIMESTAMP
);
