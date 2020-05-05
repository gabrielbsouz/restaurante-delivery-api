CREATE TABLE ESTADO (
	id bigint not null auto_increment,
    nome varchar(80) not null,

    primary key(id)
) engine=InnoDB default charset=utf8;

ALTER TABLE CIDADE ADD COLUMN estado_id bigint not null;

ALTER TABLE CIDADE ADD CONSTRAINT fk_cidade_estado
FOREIGN KEY (estado_id) REFERENCES estado (id);

ALTER TABLE CIDADE DROP COLUMN nome_estado;

ALTER TABLE CIDADE CHANGE nome_cidade nome VARCHAR(80) not null;