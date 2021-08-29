-- MySQL Script generated by MySQL Workbench
-- Mon Aug 23 19:02:47 2021
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `trellofa` ;

-- -----------------------------------------------------organization
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `trellofa` DEFAULT CHARACTER SET utf8 ;
USE `trellofa` ;

-- -----------------------------------------------------
-- Table `mydb`.`Organization`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `trellofa`.`Organization` ;

CREATE TABLE IF NOT EXISTS `trellofa`.`Organization` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NULL,
  `display_name` VARCHAR(255) NULL,
  `desc` VARCHAR(255) NULL,
  `invited` TINYINT(1) NULL,
  `url` VARCHAR(255) NULL,
  `website` VARCHAR(255) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Member`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `trellofa`.`Member` ;

CREATE TABLE IF NOT EXISTS `trellofa`.`Member` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_name` VARCHAR(255) NULL,
  `full_name` VARCHAR(255) NULL,
  `avatar_source` VARCHAR(255) NULL,
  `bio` VARCHAR(255) NULL,
  `initials` VARCHAR(45) NULL,
  `member_type` VARCHAR(255) NULL,
  `status` VARCHAR(255) NULL,
  `url` VARCHAR(255) NULL,
  `confirmed` TINYINT(1) NULL,
  `email` VARCHAR(255) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Board`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `trellofa`.`Board` ;

CREATE TABLE IF NOT EXISTS `trellofa`.`Board` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NULL,
  `desc` mediumtext NULL,
  `closed` TINYINT(1) NULL,
  `pinned` TINYINT(1) NULL,
  `url` VARCHAR(255) NULL,
  `invited` TINYINT(1) NULL,
  `short_url` VARCHAR(150) NULL,
  `subscribed` TINYINT(1) NULL,
  `date_last_activity` DATETIME NULL,
  `date_last_view` DATETIME NULL,
  `short_link` VARCHAR(150) NULL,
  `id_organization` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_Board_Organization1`
    FOREIGN KEY (`id_organization`)
    REFERENCES `trellofa`.`Organization` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`MembershipType`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `trellofa`.`MembershipType` ;

CREATE TABLE IF NOT EXISTS `trellofa`.`MembershipType` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Type` VARCHAR(255) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Membership`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `trellofa`.`Membership` ;

CREATE TABLE IF NOT EXISTS `trellofa`.`Membership` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `id_organization` INT NOT NULL,
  `id_member` INT NOT NULL,
  `id_membership_type` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_Membership_Organization`
    FOREIGN KEY (`id_organization`)
    REFERENCES `trellofa`.`Organization` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Membership_Member1`
    FOREIGN KEY (`id_member`)
    REFERENCES `trellofa`.`Member` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Membership_MembershipType1`
    FOREIGN KEY (`id_membership_type`)
    REFERENCES `trellofa`.`MembershipType` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`List`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `trellofa`.`List` ;

CREATE TABLE IF NOT EXISTS `trellofa`.`List` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NULL,
  `closed` TINYINT(1) NULL,
  `pos` INT NULL,
  `subscribed` TINYINT(1) NULL,
  `id_board` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_List_Board1`
    FOREIGN KEY (`id_board`)
    REFERENCES `trellofa`.`Board` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Card`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `trellofa`.`Card` ;

CREATE TABLE IF NOT EXISTS `trellofa`.`Card` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NULL,
  `desc` mediumtext NULL,
  `url` VARCHAR(255) NULL,
  `due` DATE NULL,
  `due_complete` TINYINT(1) NULL,
  `closed` TINYINT(1) NULL,
  `date_last_activity` DATE NULL,
  `id_short` VARCHAR(150) NULL,
  `pos` BIGINT(10) NULL,
  `short_link` VARCHAR(150) NULL,
  `short_url` VARCHAR(150) NULL,
  `subscribed` TINYINT(1) NULL,
  `id_list` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_Card_List1`
    FOREIGN KEY (`id_list`)
    REFERENCES `trellofa`.`List` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Attachment`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `trellofa`.`Attachment` ;

CREATE TABLE IF NOT EXISTS `trellofa`.`Attachment` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `bytes` INT NULL,
  `date` DATE NULL,
  `is_upload` TINYINT(1) NULL,
  `mime_type` VARCHAR(255) NULL,
  `name` VARCHAR(255) NULL,
  `url` VARCHAR(255) NULL,
  `id_member` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_Attachment_Member1`
    FOREIGN KEY (`id_member`)
    REFERENCES `trellofa`.`Member` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Label`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `trellofa`.`Label` ;

CREATE TABLE IF NOT EXISTS `trellofa`.`Label` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `color` VARCHAR(255) NULL,
  `name` VARCHAR(255) NULL,
  `text` mediumtext NULL,
  `id_card` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_Label_Card1`
    FOREIGN KEY (`id_card`)
    REFERENCES `trellofa`.`Card` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Comment`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `trellofa`.`Comment` ;

CREATE TABLE IF NOT EXISTS `trellofa`.`Comment` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `text` mediumtext NULL,
  `date` DATE NULL,
  `id_card` INT NOT NULL,
  `id_member` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_Comment_Card1`
    FOREIGN KEY (`id_card`)
    REFERENCES `trellofa`.`Card` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Comment_Member1`
    FOREIGN KEY (`id_member`)
    REFERENCES `trellofa`.`Member` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Board_has_Members`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `trellofa`.`Board_has_Members` ;

CREATE TABLE IF NOT EXISTS `trellofa`.`Board_has_Members` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `id_board` INT NOT NULL,
  `id_member` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_Board_has_Members_Board1`
    FOREIGN KEY (`id_board`)
    REFERENCES `trellofa`.`Board` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Board_has_Members_Member1`
    FOREIGN KEY (`id_member`)
    REFERENCES `trellofa`.`Member` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;