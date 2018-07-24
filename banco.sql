# criar banco
#DROP DATABASE IF EXISTS `lami`;
CREATE DATABASE IF NOT EXISTS `lami`;
USE `lami`;
#destroy tabelas
DROP TABLE IF EXISTS `c_permissao`;
DROP TABLE IF EXISTS `c_funcao`;
DROP TABLE IF EXISTS `c_modulo`;
DROP TABLE IF EXISTS `c_usuario_grupo`;
DROP TABLE IF EXISTS `c_grupo`;
DROP TABLE IF EXISTS `c_usuario_pessoa_juridica`;
DROP TABLE IF EXISTS `c_usuario`;
DROP TABLE IF EXISTS `c_localidade`;
DROP TABLE IF EXISTS `c_bairro`;
DROP TABLE IF EXISTS `c_endereco`;
DROP TABLE IF EXISTS `c_fornecedor`;
DROP TABLE IF EXISTS `c_pessoa_fisica`;
DROP TABLE IF EXISTS `c_pessoa_juridica`;
DROP TABLE IF EXISTS `c_cidade`;
DROP TABLE IF EXISTS `c_uf`;
# Modulo: Cadastro (C)
CREATE TABLE IF NOT EXISTS`c_uf` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(50) NOT NULL,
  `sigla` CHAR(2) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `sigla_idx` (`sigla` ASC)
);
CREATE TABLE IF NOT EXISTS `c_cidade`(
 `id` INT NOT NULL AUTO_INCREMENT,
 `nome` VARCHAR(50) NOT NULL,
 `ufId` INT NOT NULL,
  PRIMARY KEY(`id`),
  INDEX `cidadeUf_idx` (`ufId` ASC),
  CONSTRAINT `cidade_uf_id`
	FOREIGN KEY (`ufId`)
	REFERENCES `c_uf` (`id`)
);
CREATE TABLE IF NOT EXISTS `c_bairro`(
 `id` INT NOT NULL AUTO_INCREMENT,
 `nome` VARCHAR(50) NOT NULL,
 `cidadeId` INT NOT NULL,
 `versao` INT NOT NULL,
  PRIMARY KEY(`id`),
  INDEX `bairroCidade_idx` (`cidadeId` ASC),
  CONSTRAINT `bairro_cidade_id`
	FOREIGN KEY (`cidadeId`)
	REFERENCES `c_cidade` (`id`)
);
CREATE TABLE IF NOT EXISTS `c_localidade`(
 `id` INT NOT NULL AUTO_INCREMENT,
 `cidadeId` INT NOT NULL,
 `bairroId` INT NOT NULL,
 `cep` CHAR(8) NOT NULL,
 `logradouro` VARCHAR(200) NULL,
 `complemento` VARCHAR(100) NULL,
 `versao` INT NOT NULL,
  PRIMARY KEY(`id`),
  INDEX `localidadeCidadeIdx` (`cidadeId` ASC),
  CONSTRAINT `localidadeCidadeId`
	FOREIGN KEY (`cidadeId`)
	REFERENCES `c_cidade` (`id`),
  INDEX `localidadeBairroIdx` (`bairroId` ASC),
  CONSTRAINT `localidadeBairroId`
	FOREIGN KEY (`bairroId`)
	REFERENCES `c_bairro` (`id`)
);
CREATE TABLE IF NOT EXISTS `c_modulo`(
 `id` INT NOT NULL AUTO_INCREMENT,
 `nome` VARCHAR(25) NOT NULL,
 `descricao` VARCHAR(100) NOT NULL,
 `versao` INT NOT NULL,
  PRIMARY KEY(`id`)
);
CREATE TABLE IF NOT EXISTS `c_funcao`(
 `id` INT NOT NULL AUTO_INCREMENT,
 `nome` VARCHAR(25) NOT NULL,
 `descricao` VARCHAR(100) NOT NULL,
 `moduloId` INT NOT NULL,
 `versao` INT NOT NULL,
  PRIMARY KEY(`id`),
  INDEX `funcaoModulo_idx` (`moduloId` ASC),
  CONSTRAINT `funcao_modulo_id`
	FOREIGN KEY (`moduloId`)
	REFERENCES `c_modulo` (`id`)
);

CREATE TABLE IF NOT EXISTS `c_grupo`(
 `id` INT NOT NULL AUTO_INCREMENT,
 `nome` VARCHAR(25) NOT NULL,
 `descricao` VARCHAR(100) NOT NULL,
 `versao` INT NOT NULL,
  PRIMARY KEY(`id`)
);
CREATE TABLE IF NOT EXISTS `c_permissao`(
 `id` INT NOT NULL AUTO_INCREMENT,
 `grupoId` INT NOT NULL,
 `funcaoId` INT NOT NULL,
 `ler` TINYINT NOT NULL,
 `criar` TINYINT NOT NULL,
 `modificar` TINYINT NOT NULL,
 `apagar` TINYINT NOT NULL,
 `versao` INT NOT NULL,
  PRIMARY KEY(`id`),
  INDEX `permissaoGrupo_idx` (`grupoId` ASC),
  CONSTRAINT `permissao_grupo_id`
	FOREIGN KEY (`grupoId`)
	REFERENCES `c_grupo` (`id`),
  INDEX `permissaoFuncao_idx` (`funcaoId` ASC),
  CONSTRAINT `permissao_funcao_id`
	FOREIGN KEY (`funcaoId`)
	REFERENCES `c_funcao` (`id`)
);
CREATE TABLE IF NOT EXISTS `c_pessoa_juridica`(
 `id` INT NOT NULL AUTO_INCREMENT,
 `cnpj` CHAR(14) NOT NULL,
 `razao` VARCHAR(150) NOT NULL,
 `fantasia` VARCHAR(150) NULL,
 `email` VARCHAR(50) NOT NULL,
 `ie` VARCHAR(20) NULL,
 `cnae` VARCHAR(10) NULL,
 `versao` INT NOT NULL,
  PRIMARY KEY(`id`)
);

CREATE TABLE IF NOT EXISTS `c_pessoa_fisica`(
 `id` INT NOT NULL AUTO_INCREMENT,
 `cpf` CHAR(11) NOT NULL,
 `nome` VARCHAR(200) NULL,
 `email` VARCHAR(200) NULL,
 `telefone` VARCHAR(13) NULL,
 `versao` INT NOT NULL,
 PRIMARY KEY(`id`),
 UNIQUE INDEX (`cpf` ASC)
);
CREATE TABLE IF NOT EXISTS `c_usuario`(
 `id` INT NOT NULL AUTO_INCREMENT,
 `email` VARCHAR(50) NOT NULL,
 `cpf` CHAR(12) NOT NULL,
 `pessoaFisicaId` INT NOT NULL,
 `ativo` TINYINT NOT NULL,
 `versao` INT NOT NULL,
  PRIMARY KEY(`id`),
  UNIQUE INDEX (`cpf` ASC),
  INDEX `usuarioPessoaFisica_idx` (`pessoaFisicaId` ASC),
  CONSTRAINT `usuario_pessoa_fisica_id`
	FOREIGN KEY (`pessoaFisicaId`)
	REFERENCES `c_pessoa_fisica` (`id`)
);
CREATE TABLE IF NOT EXISTS `c_usuario_pessoa_juridica`(
 `usuarioId` INT NOT NULL,
 `pessoaJuridicaId` INT NOT NULL,
  PRIMARY KEY(`usuarioId`, `pessoaJuridicaId`),
  INDEX `usuarioPessoaJuridica_idx1` (`usuarioId` ASC),
  CONSTRAINT `usuario_pessoa_juridica_id1`
	FOREIGN KEY (`usuarioId`)
	REFERENCES `c_usuario` (`id`),
  INDEX `usuarioPessoaJuridica_idx2` (`pessoaJuridicaId` ASC),
  CONSTRAINT `usuario_pessoa_juridica_id`
	FOREIGN KEY (`pessoaJuridicaId`)
	REFERENCES `c_pessoa_juridica` (`id`)
);
CREATE TABLE IF NOT EXISTS `c_endereco`(
 `id` INT NOT NULL,
 `cidadeId` INT NOT NULL,
 `cep` CHAR(8) NULL,
 `logradouro` VARCHAR(100) NULL,
 `complemento` VARCHAR(100) NULL,
 `bairroId` INT NOT NULL,
 `pessoaFisicaId` INT NOT NULL,
 `pessoaJuridicaId` INT NOT NULL,
 `versao` INT NOT NULL,
 PRIMARY KEY(`id`),
 INDEX `enderecoCidade_idx` (`cidadeId` ASC),
  CONSTRAINT `endereco_cidade_id`
	FOREIGN KEY (`cidadeId`)
	REFERENCES `c_cidade` (`id`),
 INDEX `enderecoBairro_idx` (`bairroId` ASC),
  CONSTRAINT `endereco_bairro_id`
	FOREIGN KEY (`bairroId`)
	REFERENCES `c_bairro` (`id`),
 INDEX `enderecoPessoaFisica_idx` (`pessoaFisicaId` ASC),
  CONSTRAINT `endereco_pessoa_fisica_id`
	FOREIGN KEY (`pessoaFisicaId`)
	REFERENCES `c_pessoa_fisica` (`id`),
 INDEX `enderecoPessoaJuridica_idx` (`pessoaJuridicaId` ASC),
  CONSTRAINT `endereco_pessoa_juridica_id`
	FOREIGN KEY (`pessoaJuridicaId`)
	REFERENCES `c_pessoa_juridica` (`id`)
);

CREATE TABLE IF NOT EXISTS `c_fornecedor`(
 `id` INT NOT NULL,
 `versao` INT NOT NULL,
 PRIMARY KEY(`id`),
 CONSTRAINT `C_FornecedorC_PessoaJuridicaIdx`
	FOREIGN KEY (`id`)
    REFERENCES `c_pessoa_juridica` (`id`)
);
# fim - Modulo cadastro