
-- -----------------------------------------------------
-- Schema sport
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `sport` ;

-- -----------------------------------------------------
-- Schema sport
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `sport` DEFAULT CHARACTER SET utf8 ;
USE `sport` ;

-- -----------------------------------------------------
-- Table `sport`.`administrator`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sport`.`administrator` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `admin_hash` VARCHAR(255) NULL DEFAULT NULL,
  `email` VARCHAR(255) NULL DEFAULT NULL,
  `login` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sport`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sport`.`user` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(255) NULL DEFAULT NULL,
  `first_name` VARCHAR(255) NULL DEFAULT NULL,
  `last_name` VARCHAR(255) NULL DEFAULT NULL,
  `phone` VARCHAR(255) NULL DEFAULT NULL,
  `user_hash` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sport`.`card`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sport`.`card` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(255) NULL DEFAULT NULL,
  `expiration_date` VARCHAR(255) NULL DEFAULT NULL,
  `issue_date` VARCHAR(255) NULL DEFAULT NULL,
  `pin_code` INT(11) NULL DEFAULT NULL,
  `user` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FKn9vorop1tar7hj704dj3u3gk8` (`user` ASC),
  CONSTRAINT `FKn9vorop1tar7hj704dj3u3gk8`
    FOREIGN KEY (`user`)
    REFERENCES `sport`.`user` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sport`.`contact_type`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sport`.`contact_type` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sport`.`filiation`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sport`.`filiation` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `building` VARCHAR(255) NULL DEFAULT NULL,
  `caption` VARCHAR(255) NULL DEFAULT NULL,
  `city` VARCHAR(255) NULL DEFAULT NULL,
  `country` VARCHAR(255) NULL DEFAULT NULL,
  `index_city` VARCHAR(255) NULL DEFAULT NULL,
  `street` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sport`.`contact`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sport`.`contact` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `data` VARCHAR(255) NULL DEFAULT NULL,
  `contact_type_id` INT(11) NULL DEFAULT NULL,
  `filiation_id` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FKdfk36t9g84bda18adscgwubnu` (`contact_type_id` ASC),
  INDEX `FKnm5rxsq9f5wlvtnbdppeo63dh` (`filiation_id` ASC),
  CONSTRAINT `FKdfk36t9g84bda18adscgwubnu`
    FOREIGN KEY (`contact_type_id`)
    REFERENCES `sport`.`contact_type` (`id`),
  CONSTRAINT `FKnm5rxsq9f5wlvtnbdppeo63dh`
    FOREIGN KEY (`filiation_id`)
    REFERENCES `sport`.`filiation` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sport`.`day`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sport`.`day` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sport`.`news`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sport`.`news` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `date` VARCHAR(255) NULL DEFAULT NULL,
  `description` TEXT NULL DEFAULT NULL,
  `image_url` TEXT NULL DEFAULT NULL,
  `title` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sport`.`training_type`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sport`.`training_type` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `description` TEXT NULL DEFAULT NULL,
  `name` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sport`.`training`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sport`.`training` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `time` TIME NULL DEFAULT NULL,
  `day` INT(11) NULL DEFAULT NULL,
  `filiation` INT(11) NULL DEFAULT NULL,
  `type` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FKlpm62c52vrhibss7vnhcsuxdw` (`day` ASC),
  INDEX `FK9y0xmnrj0f4pe3mm2xw2721ad` (`filiation` ASC),
  INDEX `FK203sh4xmn4shve3fkv8g0s7io` (`type` ASC),
  CONSTRAINT `FK203sh4xmn4shve3fkv8g0s7io`
    FOREIGN KEY (`type`)
    REFERENCES `sport`.`training_type` (`id`),
  CONSTRAINT `FK9y0xmnrj0f4pe3mm2xw2721ad`
    FOREIGN KEY (`filiation`)
    REFERENCES `sport`.`filiation` (`id`),
  CONSTRAINT `FKlpm62c52vrhibss7vnhcsuxdw`
    FOREIGN KEY (`day`)
    REFERENCES `sport`.`day` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
