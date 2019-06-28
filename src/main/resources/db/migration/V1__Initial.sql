-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema myaccounting
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema myaccounting
-- -----------------------------------------------------

USE `myaccounting` ;

-- -----------------------------------------------------
-- Table `myaccounting`.`expense_types`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `myaccounting`.`expense_types` ( `id` INT NOT NULL AUTO_INCREMENT,  
`name` VARCHAR(45) NULL, 
`create_date` DATETIME NULL,  
`update_date` DATETIME NULL,  
PRIMARY KEY (`id`),  
UNIQUE INDEX `id_UNIQUE` (`id` ASC) ) ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `myaccounting`.`patyment_types`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `myaccounting`.`payment_types` (  `id` INT NOT NULL AUTO_INCREMENT,  
`name` VARCHAR(45) NULL, 
`create_date` DATETIME NULL, 
`update_date` DATETIME NULL,   
PRIMARY KEY (`id`))ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `myaccounting`.`expenses`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `myaccounting`.`expenses` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `description` TEXT NULL,
  `create_date` DATETIME NULL,
  `update_date` DATETIME NULL,
  `expense_type_id` INT NOT NULL,
  `payment_type_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) ,
  INDEX `fk_expense_expense_type_idx` (`expense_type_id` ASC) ,
  INDEX `fk_expense_payment_type1w_idx` (`payment_type_id` ASC) ,
  CONSTRAINT `fk_expense_expense_type`
    FOREIGN KEY (`expense_type_id`)
    REFERENCES `myaccounting`.`expense_types` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_expense_payment_type`
    FOREIGN KEY (`payment_type_id`)
    REFERENCES `myaccounting`.`patyment_types` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;