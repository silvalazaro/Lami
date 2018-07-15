# criar banco
#DROP DATABASE IF EXISTS `lami`;
CREATE DATABASE IF NOT EXISTS `lami`;
USE `lami`;
#destroy tabelas
DROP TABLE IF EXISTS `c_endereco`;
DROP TABLE IF EXISTS `c_fornecedor`;
DROP TABLE IF EXISTS `c_pessoa_fisica`;
DROP TABLE IF EXISTS `c_pessoa_juridica`;
DROP TABLE IF EXISTS `c_localidade`;
DROP TABLE IF EXISTS `c_cidade`;
DROP TABLE IF EXISTS `c_uf`;
# Modulo: Cadastro (C)
CREATE TABLE IF NOT EXISTS`c_uf` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(50) NOT NULL,
  `uf` CHAR(2) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `uf_idx` (`uf` ASC)
);
CREATE TABLE IF NOT EXISTS `c_cidade`(
 `id` INT NOT NULL AUTO_INCREMENT,
 `nome` VARCHAR(50) NOT NULL,
 `ufId` INT NOT NULL,
  PRIMARY KEY(`id`),
  INDEX `cidadeUf_idx` (`ufId` ASC),
  CONSTRAINT `cidade_Uf_id`
	FOREIGN KEY (`ufId`)
	REFERENCES `c_uf` (`id`)
);
CREATE TABLE IF NOT EXISTS `c_localidade`(
 `id` INT NOT NULL AUTO_INCREMENT,
 `cep` CHAR(8) NOT NULL,
 `cidadeId` INT NOT NULL,
 `logradouro` VARCHAR(200) NULL,
 `complemento` VARCHAR(100) NULL,
 `bairro` VARCHAR(50) NULL,
  PRIMARY KEY(`id`),
  INDEX `localidadeCidadeIdx` (`cidadeId` ASC),
  CONSTRAINT `localidadeCidadeId`
	FOREIGN KEY (`cidadeId`)
	REFERENCES `c_cidade` (`id`)
);

CREATE TABLE IF NOT EXISTS `c_pessoa_juridica`(
 `id` INT NOT NULL AUTO_INCREMENT,
 `cnpj` CHAR(14) NOT NULL,
 `razao` VARCHAR(150) NOT NULL,
 `fantasia` VARCHAR(150) NULL,
 `email` VARCHAR(50) NOT NULL,
 `ie` VARCHAR(20) NULL,
 `cnae` VARCHAR(10) NULL,
  PRIMARY KEY(`id`)
);

CREATE TABLE IF NOT EXISTS `c_pessoa_fisica`(
 `id` INT NOT NULL AUTO_INCREMENT,
 `cpf` CHAR(11) NOT NULL,
 `nome` VARCHAR(200) NULL,
 `email` VARCHAR(200) NULL,
 `telefone` VARCHAR(13) NULL,
 PRIMARY KEY(`id`),
 UNIQUE INDEX (`cpf` ASC)
);

CREATE TABLE IF NOT EXISTS `c_endereco`(
 `id` INT NOT NULL,
 `cpf` CHAR(11) NOT NULL,
 `nome` VARCHAR(200) NULL,
 `email` VARCHAR(200) NULL,
 `telefone` VARCHAR(13) NULL,
 PRIMARY KEY(`id`),
 UNIQUE INDEX (`cpf` ASC)
);

CREATE TABLE IF NOT EXISTS `c_fornecedor`(
 `id` INT NOT NULL,
 PRIMARY KEY(`id`),
 CONSTRAINT `C_FornecedorC_PessoaJuridicaIdx`
	FOREIGN KEY (`id`)
    REFERENCES `c_pessoa_juridica` (`id`)
);
# fim - Modulo cadastro