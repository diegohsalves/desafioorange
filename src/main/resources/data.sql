DROP TABLE IF EXISTS usuario;
DROP TABLE IF EXISTS veiculo;

CREATE TABLE usuario (
  cpf VARCHAR(11) NOT NULL,
  nome VARCHAR(50) NOT NULL,
  email VARCHAR(50) NOT NULL,
  nascimento DATE NOT NULL,
  PRIMARY KEY (cpf)
);

CREATE TABLE veiculo (
    id INT NOT NULL AUTO_INCREMENT,
    marca VARCHAR(50) NOT NULL,
    modelo VARCHAR(50) NOT NULL,
    ano VARCHAR(20) NOT NULL,
    valor VARCHAR(20) NOT NULL,
    cpf_proprietario VARCHAR(11) NOT NULL,
    FOREIGN KEY (cpf_proprietario) REFERENCES usuario(cpf),
    PRIMARY KEY (id)
)
