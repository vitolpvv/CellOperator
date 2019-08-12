-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema celloperator
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `celloperator` ;

-- -----------------------------------------------------
-- Schema celloperator
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `celloperator` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
USE `celloperator` ;

-- -----------------------------------------------------
-- Table `celloperator`.`payment_period`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `celloperator`.`payment_period` ;

CREATE TABLE IF NOT EXISTS `celloperator`.`payment_period` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `celloperator`.`tariff_option`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `celloperator`.`tariff_option` ;

CREATE TABLE IF NOT EXISTS `celloperator`.`tariff_option` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `description` VARCHAR(100) NULL,
  `price_use` DECIMAL(6,2) NOT NULL,
  `payment_period_id` INT UNSIGNED NOT NULL,
  `permanent` BIT(1) NOT NULL DEFAULT 0,
  `archived` BIT(1) NOT NULL DEFAULT 0,
  `price_set` DECIMAL(6,2) NULL,
  `parent_option_id` INT UNSIGNED NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC),
  INDEX `fk_option_option_idx` (`parent_option_id` ASC),
  INDEX `fk_option_payment_period1_idx` (`payment_period_id` ASC),
  CONSTRAINT `fk_option_option`
    FOREIGN KEY (`parent_option_id`)
    REFERENCES `celloperator`.`tariff_option` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_option_payment_period1`
    FOREIGN KEY (`payment_period_id`)
    REFERENCES `celloperator`.`payment_period` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `celloperator`.`option_incompatibility`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `celloperator`.`option_incompatibility` ;

CREATE TABLE IF NOT EXISTS `celloperator`.`option_incompatibility` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `option1_id` INT UNSIGNED NOT NULL,
  `option2_id` INT UNSIGNED NOT NULL,
  INDEX `fk_option_incompatibility_option1_idx` (`option1_id` ASC),
  INDEX `fk_option_incompatibility_option2_idx` (`option2_id` ASC),
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_option_incompatibility_option1`
    FOREIGN KEY (`option1_id`)
    REFERENCES `celloperator`.`tariff_option` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_option_incompatibility_option2`
    FOREIGN KEY (`option2_id`)
    REFERENCES `celloperator`.`tariff_option` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `celloperator`.`tariff`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `celloperator`.`tariff` ;

CREATE TABLE IF NOT EXISTS `celloperator`.`tariff` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `description` VARCHAR(100) NULL,
  `price_use` DECIMAL(6,2) NOT NULL,
  `payment_period_id` INT UNSIGNED NOT NULL,
  `archived` BIT(1) NOT NULL DEFAULT 0,
  `price_set` DECIMAL(6,2) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC),
  INDEX `fk_tariff_payment_period1_idx` (`payment_period_id` ASC),
  CONSTRAINT `fk_tariff_payment_period1`
    FOREIGN KEY (`payment_period_id`)
    REFERENCES `celloperator`.`payment_period` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `celloperator`.`tariff_has_option`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `celloperator`.`tariff_has_option` ;

CREATE TABLE IF NOT EXISTS `celloperator`.`tariff_has_option` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `tariff_id` INT UNSIGNED NOT NULL,
  `option_id` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_tariff_has_option_option1_idx` (`option_id` ASC),
  INDEX `fk_tariff_has_option_tariff1_idx` (`tariff_id` ASC),
  CONSTRAINT `fk_tariff_has_option_tariff1`
    FOREIGN KEY (`tariff_id`)
    REFERENCES `celloperator`.`tariff` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tariff_has_option_option1`
    FOREIGN KEY (`option_id`)
    REFERENCES `celloperator`.`tariff_option` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `celloperator`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `celloperator`.`user` ;

CREATE TABLE IF NOT EXISTS `celloperator`.`user` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `firstname` VARCHAR(45) NOT NULL,
  `lastname` VARCHAR(45) NOT NULL,
  `blocked` BIT(1) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `celloperator`.`contract`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `celloperator`.`contract` ;

CREATE TABLE IF NOT EXISTS `celloperator`.`contract` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `number` VARCHAR(10) NOT NULL,
  `tariff_id` INT UNSIGNED NOT NULL,
  `user_id` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `number_UNIQUE` (`number` ASC),
  INDEX `fk_contract_tariff1_idx` (`tariff_id` ASC),
  INDEX `fk_contract_user1_idx` (`user_id` ASC),
  CONSTRAINT `fk_contract_tariff1`
    FOREIGN KEY (`tariff_id`)
    REFERENCES `celloperator`.`tariff` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_contract_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `celloperator`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `celloperator`.`contract_has_option`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `celloperator`.`contract_has_option` ;

CREATE TABLE IF NOT EXISTS `celloperator`.`contract_has_option` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `contract_id` INT UNSIGNED NOT NULL,
  `option_id` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Contract_has_option_option1_idx` (`option_id` ASC),
  INDEX `fk_Contract_has_option_Contract1_idx` (`contract_id` ASC),
  CONSTRAINT `fk_Contract_has_option_Contract1`
    FOREIGN KEY (`contract_id`)
    REFERENCES `celloperator`.`contract` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Contract_has_option_option1`
    FOREIGN KEY (`option_id`)
    REFERENCES `celloperator`.`tariff_option` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `celloperator`.`role`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `celloperator`.`role` ;

CREATE TABLE IF NOT EXISTS `celloperator`.`role` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `celloperator`.`user_info`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `celloperator`.`user_info` ;

CREATE TABLE IF NOT EXISTS `celloperator`.`user_info` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_id` INT UNSIGNED NOT NULL,
  `birthday` DATE NOT NULL,
  `passport` VARCHAR(45) NOT NULL,
  `address` VARCHAR(200) NOT NULL,
  `email` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC),
  CONSTRAINT `fk_user_info_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `celloperator`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `celloperator`.`credential`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `celloperator`.`credential` ;

CREATE TABLE IF NOT EXISTS `celloperator`.`credential` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_id` INT UNSIGNED NOT NULL,
  `login` VARCHAR(45) NULL,
  `pwd_md5` CHAR(32) NOT NULL,
  INDEX `fk_credential_user1_idx` (`user_id` ASC),
  PRIMARY KEY (`id`),
  UNIQUE INDEX `login_UNIQUE` (`login` ASC),
  CONSTRAINT `fk_credential_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `celloperator`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `celloperator`.`contract_blocked`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `celloperator`.`contract_blocked` ;

CREATE TABLE IF NOT EXISTS `celloperator`.`contract_blocked` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `contract_id` INT UNSIGNED NOT NULL,
  `initiator_id` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_contract_disabled_user1_idx` (`initiator_id` ASC),
  UNIQUE INDEX `contract_id_UNIQUE` (`contract_id` ASC),
  CONSTRAINT `fk_contract_disabled_contract1`
    FOREIGN KEY (`contract_id`)
    REFERENCES `celloperator`.`contract` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_contract_disabled_user1`
    FOREIGN KEY (`initiator_id`)
    REFERENCES `celloperator`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `celloperator`.`user_has_role`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `celloperator`.`user_has_role` ;

CREATE TABLE IF NOT EXISTS `celloperator`.`user_has_role` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_id` INT UNSIGNED NOT NULL,
  `role_id` INT UNSIGNED NOT NULL,
  INDEX `fk_user_has_role_role1_idx` (`role_id` ASC),
  INDEX `fk_user_has_role_user1_idx` (`user_id` ASC),
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_user_has_role_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `celloperator`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_has_role_role1`
    FOREIGN KEY (`role_id`)
    REFERENCES `celloperator`.`role` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `celloperator`.`payment_period`
-- -----------------------------------------------------
START TRANSACTION;
USE `celloperator`;
INSERT INTO `celloperator`.`payment_period` (`id`, `name`) VALUES (DEFAULT, 'сутки');
INSERT INTO `celloperator`.`payment_period` (`id`, `name`) VALUES (DEFAULT, 'месяц');

COMMIT;


-- -----------------------------------------------------
-- Data for table `celloperator`.`role`
-- -----------------------------------------------------
START TRANSACTION;
USE `celloperator`;
INSERT INTO `celloperator`.`role` (`id`, `name`) VALUES (DEFAULT, 'CLIENT');
INSERT INTO `celloperator`.`role` (`id`, `name`) VALUES (DEFAULT, 'MANAGER');
INSERT INTO `celloperator`.`role` (`id`, `name`) VALUES (DEFAULT, 'ADMIN');

COMMIT;

