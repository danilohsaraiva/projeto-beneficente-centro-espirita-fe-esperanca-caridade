DROP DATABASE IF EXISTS `dbcentroespirita` ;
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema dbcentroespirita
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema dbcentroespirita
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `dbcentroespirita` DEFAULT CHARACTER SET utf8 ;
USE `dbcentroespirita` ;

-- -----------------------------------------------------
-- Table `dbcentroespirita`.`Limitacao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbcentroespirita`.`Limitacao` (
  `id_limitacao` BIGINT NOT NULL AUTO_INCREMENT,
  `eh_cognitiva` TINYINT NULL,
  `eh_locomocao` TINYINT NULL,
  `eh_visao` TINYINT NULL,
  `eh_audicao` TINYINT NULL,
  `outro_descricao` VARCHAR(45) NULL,
  PRIMARY KEY (`id_limitacao`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dbcentroespirita`.`Endereco`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbcentroespirita`.`Endereco` (
  `id_endereco` BIGINT NOT NULL AUTO_INCREMENT,
  `cep` VARCHAR(8) NOT NULL,
  `logradouroEndereco` VARCHAR(45) NOT NULL,
  `cidade` VARCHAR(45) NOT NULL,
  `uf` CHAR(2) NOT NULL,
  `bairro` VARCHAR(45) NOT NULL,
  `complemento` VARCHAR(45) NULL,
  `numero` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`id_endereco`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dbcentroespirita`.`Prontuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbcentroespirita`.`Prontuario` (
  `id_prontuario` BIGINT NOT NULL AUTO_INCREMENT,
  `data_abertura` DATETIME NOT NULL,
  PRIMARY KEY (`id_prontuario`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dbcentroespirita`.`Paciente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbcentroespirita`.`Paciente` (
  `id_paciente` BIGINT NOT NULL AUTO_INCREMENT,
  `cpfPaciente` VARCHAR(11) NOT NULL,
  `rg_paciente` VARCHAR(45) NOT NULL,
  `nome_completo_paciente` VARCHAR(50) NOT NULL,
  `data_nascimento_paciente` DATETIME NOT NULL,
  `sexo_biologico_paciente` VARCHAR(1) NOT NULL,
  `estado_civil` VARCHAR(45) NOT NULL,
  `genero_paciente` VARCHAR(45) NOT NULL,
  `email_paciente` VARCHAR(45) NULL,
  `escolaridade_paciente` VARCHAR(45) NOT NULL,
  `ocupacao_paciente` VARCHAR(45) NOT NULL,
  `fk_limitacao` BIGINT NULL,
  `fk_endereco` BIGINT NOT NULL,
  `naturalidade` VARCHAR(45) NOT NULL,
  `nacionalidade` VARCHAR(45) NOT NULL,
  `cor_raca` VARCHAR(45) NULL,
  `cartao_nascional_saude` VARCHAR(45) NOT NULL,
  `fk_prontuario` BIGINT NULL,
  PRIMARY KEY (`id_paciente`),
  INDEX `fk_limitacao_idx` (`fk_limitacao` ASC) VISIBLE,
  INDEX `fk_endereco_idx` (`fk_endereco` ASC) VISIBLE,
  INDEX `fk_prontuario_idx` (`fk_prontuario` ASC) VISIBLE,
  CONSTRAINT `fk_limitacao`
    FOREIGN KEY (`fk_limitacao`)
    REFERENCES `dbcentroespirita`.`Limitacao` (`id_limitacao`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_endereco`
    FOREIGN KEY (`fk_endereco`)
    REFERENCES `dbcentroespirita`.`Endereco` (`id_endereco`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_prontuario`
    FOREIGN KEY (`fk_prontuario`)
    REFERENCES `dbcentroespirita`.`Prontuario` (`id_prontuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dbcentroespirita`.`TelefoneContatoEmergencia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbcentroespirita`.`TelefoneContatoEmergencia` (
  `id_telefone_contato_emergencia` BIGINT NOT NULL AUTO_INCREMENT,
  `nome_contato_emergencia` VARCHAR(45) NOT NULL,
  `telefone_contato_emergencia` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_telefone_contato_emergencia`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dbcentroespirita`.`Usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbcentroespirita`.`Usuario` (
  `id_usuario` BIGINT NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(45) NOT NULL UNIQUE,
  `senha` VARCHAR(45) NOT NULL,
  `tipo_acesso` CHAR(3) NOT NULL,
  PRIMARY KEY (`id_usuario`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dbcentroespirita`.`Atendimento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbcentroespirita`.`Atendimento` (
  `id_atendimento` BIGINT NOT NULL AUTO_INCREMENT,
  `fk_prontuario` BIGINT NOT NULL,
  `tipo_atendimento` TINYINT NOT NULL,
  `prioridade` ENUM("Emergência", "Muito urgente", "Urgente", "Pouco urgente", "Não Urgente") NOT NULL,
  `status_atendimento` ENUM("Em Aguardo", "Pendente", "Cancelado", "Não Compareceu", "Concluído", "Reaberto") NOT NULL,
  `tratamento` TEXT(150) NULL,
  `diagnostico` TEXT(150) NULL,
  `observacao` VARCHAR(45) NULL,
  INDEX `fk_prontuario_atendimento_idx` (`fk_prontuario` ASC) VISIBLE,
  PRIMARY KEY (`id_atendimento`),
  CONSTRAINT `fk_prontuario_atendimento`
    FOREIGN KEY (`fk_prontuario`)
    REFERENCES `dbcentroespirita`.`Prontuario` (`id_prontuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dbcentroespirita`.`AnamneseAtendimentoPsicologico`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbcentroespirita`.`AnamneseAtendimentoPsicologico` (
  `id_anamnese_psicologico` BIGINT NOT NULL AUTO_INCREMENT,
  `motivo_consulta_descricao` VARCHAR(45) NOT NULL,
  `tempo_sintomas` VARCHAR(45) NOT NULL,
  `fatores_agravantes` VARCHAR(45) NOT NULL,
  `medicamentos_uso` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_anamnese_psicologico`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dbcentroespirita`.`AnamneseAtendimendoClinico`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbcentroespirita`.`AnamneseAtendimendoClinico` (
  `id_anamnese_clinico` BIGINT NOT NULL AUTO_INCREMENT,
  `motivo_consulta_descricao` VARCHAR(50) NOT NULL,
  `data_inicio` DATETIME NOT NULL,
  `sintomas_assossiados` VARCHAR(50) NOT NULL,
  `tratamento_anteriores` VARCHAR(45) NOT NULL,
  `uso_medicamento` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_anamnese_clinico`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dbcentroespirita`.`ContatoEmergenciaPaciente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbcentroespirita`.`ContatoEmergenciaPaciente` (
  `id_contato_emergencia` BIGINT NOT NULL AUTO_INCREMENT,
  `fk_paciente` BIGINT NOT NULL,
  `fk_telefone_contato_emergencia` BIGINT NOT NULL,
  PRIMARY KEY (`id_contato_emergencia`),
  INDEX `fk_telefone_contato_emergencia_idx` (`fk_telefone_contato_emergencia` ASC) VISIBLE,
  INDEX `fk_paciente_idx` (`fk_paciente` ASC) VISIBLE,
  CONSTRAINT `fk_paciente`
    FOREIGN KEY (`fk_paciente`)
    REFERENCES `dbcentroespirita`.`Paciente` (`id_paciente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_telefone_contato_emergencia`
    FOREIGN KEY (`fk_telefone_contato_emergencia`)
    REFERENCES `dbcentroespirita`.`TelefoneContatoEmergencia` (`id_telefone_contato_emergencia`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dbcentroespirita`.`Psicologo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbcentroespirita`.`Psicologo` (
  `id_psicologo` BIGINT NOT NULL AUTO_INCREMENT,
  `nome_psicologo` VARCHAR(45) NOT NULL,
  `data_nascimento_profissional` DATETIME NOT NULL,
  `sexo_psicologo` VARCHAR(45) NOT NULL,
  `fk_endereco` BIGINT NOT NULL,
  `telefone_psicologo` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `crp` VARCHAR(45) NOT NULL,
  `uf_registro_crp` CHAR(2) NOT NULL,
  `especialidade` VARCHAR(45) NOT NULL,
  `fk_usuario` BIGINT NULL,
  `rg_psicologo` VARCHAR(45) NOT NULL,
  `ur_rg` CHAR(2) NULL,
  `tipo_atendimento` ENUM("Individual", "Casal", "Familiar", "Grupo") NOT NULL DEFAULT 'Individual',
  PRIMARY KEY (`id_psicologo`),
  INDEX `fk_usuario_idx` (`fk_usuario` ASC) VISIBLE,
  INDEX `fk_endereco_psicologo_idx` (`fk_endereco` ASC) VISIBLE,
  CONSTRAINT `fk_usuario`
    FOREIGN KEY (`fk_usuario`)
    REFERENCES `dbcentroespirita`.`Usuario` (`id_usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_endereco_psicologo`
    FOREIGN KEY (`fk_endereco`)
    REFERENCES `dbcentroespirita`.`Endereco` (`id_endereco`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dbcentroespirita`.`Medico`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbcentroespirita`.`Medico` (
  `id_medico` BIGINT NOT NULL AUTO_INCREMENT,
  `nome_medico` VARCHAR(45) NOT NULL,
  `cpf_medico` VARCHAR(11) NOT NULL,
  `data_nascimento_medico` DATETIME NOT NULL,
  `sexo` CHAR(1) NOT NULL,
  `fk_endereco` BIGINT NOT NULL,
  `telefone_medico` VARCHAR(45) NOT NULL,
  `email_medico` VARCHAR(45) NOT NULL,
  `crm` VARCHAR(45) NOT NULL,
  `uf_registro_crm` CHAR(2) NOT NULL,
  `especialidade_medico` VARCHAR(45) NOT NULL,
  `fk_usuario` BIGINT NOT NULL,
  `rg_medico` VARCHAR(45) NOT NULL,
  `uf_rg_medico` CHAR(2) NULL,
  PRIMARY KEY (`id_medico`),
  INDEX `fk_usuario_psicologo_idx` (`fk_usuario` ASC) VISIBLE,
  INDEX `fk_endereco_medico_idx` (`fk_endereco` ASC) VISIBLE,
  CONSTRAINT `fk_usuario_medico`
    FOREIGN KEY (`fk_usuario`)
    REFERENCES `dbcentroespirita`.`Usuario` (`id_usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_endereco_medico`
    FOREIGN KEY (`fk_endereco`)
    REFERENCES `dbcentroespirita`.`Endereco` (`id_endereco`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dbcentroespirita`.`ConsultaMedica`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbcentroespirita`.`ConsultaMedica` (
  `id_consulta_medica` BIGINT NOT NULL AUTO_INCREMENT,
  `data_consulta` DATETIME NOT NULL,
  `fk_medico_plantao` BIGINT NOT NULL,
  PRIMARY KEY (`id_consulta_medica`),
  INDEX `fk_medico_plantao_idx` (`fk_medico_plantao` ASC) VISIBLE,
  CONSTRAINT `fk_medico_plantao`
    FOREIGN KEY (`fk_medico_plantao`)
    REFERENCES `dbcentroespirita`.`Medico` (`id_medico`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dbcentroespirita`.`ConsultaPsicologica`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbcentroespirita`.`ConsultaPsicologica` (
  `id_consulta_psicologica` BIGINT NOT NULL AUTO_INCREMENT,
  `data_consulta_psicologica` DATETIME NOT NULL,
  `fk_psicologo_plantao` BIGINT NOT NULL,
  PRIMARY KEY (`id_consulta_psicologica`),
  INDEX `fk_psicologo_plantao_idx` (`fk_psicologo_plantao` ASC) VISIBLE,
  CONSTRAINT `fk_psicologo_plantao`
    FOREIGN KEY (`fk_psicologo_plantao`)
    REFERENCES `dbcentroespirita`.`Psicologo` (`id_psicologo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dbcentroespirita`.`AtendimentosMedico`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbcentroespirita`.`AtendimentosMedico` (
  `fk_atendimento` BIGINT NOT NULL AUTO_INCREMENT,
  `fk_consulta_medica` BIGINT NOT NULL,
  `fk_anamnese` BIGINT NULL,
  INDEX `fk_atendimento_informacao_idx` (`fk_atendimento` ASC) VISIBLE,
  INDEX `fk_consulta_medica_idx` (`fk_consulta_medica` ASC) VISIBLE,
  INDEX `fk_anamnese_medica_idx` (`fk_anamnese` ASC) VISIBLE,
  CONSTRAINT `fk_atendimento_informacao`
    FOREIGN KEY (`fk_atendimento`)
    REFERENCES `dbcentroespirita`.`Atendimento` (`id_atendimento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_consulta_medica`
    FOREIGN KEY (`fk_consulta_medica`)
    REFERENCES `dbcentroespirita`.`ConsultaMedica` (`id_consulta_medica`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_anamnese_medica`
    FOREIGN KEY (`fk_anamnese`)
    REFERENCES `dbcentroespirita`.`AnamneseAtendimendoClinico` (`id_anamnese_clinico`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dbcentroespirita`.`AtendimendoPsicologico`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbcentroespirita`.`AtendimendoPsicologico` (
  `fk_atendimento` BIGINT NOT NULL AUTO_INCREMENT,
  `fk_consulta_psicologica` BIGINT NOT NULL,
  `fk_anamnese_psicologica` BIGINT NULL,
  INDEX `fk_atendimento_info_idx` (`fk_atendimento` ASC) VISIBLE,
  INDEX `fk_consulta_psicologica_idx` (`fk_consulta_psicologica` ASC) VISIBLE,
  INDEX `fk_anamnese_psicologica_idx` (`fk_anamnese_psicologica` ASC) VISIBLE,
  CONSTRAINT `fk_atendimento_info`
    FOREIGN KEY (`fk_atendimento`)
    REFERENCES `dbcentroespirita`.`Atendimento` (`id_atendimento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_consulta_psicologica`
    FOREIGN KEY (`fk_consulta_psicologica`)
    REFERENCES `dbcentroespirita`.`ConsultaPsicologica` (`id_consulta_psicologica`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_anamnese_psicologica`
    FOREIGN KEY (`fk_anamnese_psicologica`)
    REFERENCES `dbcentroespirita`.`AnamneseAtendimentoPsicologico` (`id_anamnese_psicologico`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
