CREATE TABLE IF NOT EXISTS `BankSystem`.`client` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(255) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  `role` VARCHAR(255) NOT NULL,
  `name` VARCHAR(255) NOT NULL,
  `surname` VARCHAR(255) NOT NULL,
  `patronymic` VARCHAR(255) NOT NULL,
  `address` VARCHAR(255) NOT NULL,
  `pass_number` VARCHAR(255) NOT NULL,
  `birthday` DATE NOT NULL,
  `phone_number` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `pass_number_UNIQUE` (`pass_number` ASC) VISIBLE,
  UNIQUE INDEX `phone_number_UNIQUE` (`phone_number` ASC) VISIBLE,
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE)
ENGINE = InnoDB;
GO
CREATE TABLE IF NOT EXISTS `BankSystem`.`count` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `number` VARCHAR(255) NOT NULL,
  `balance` INT NOT NULL,
  `currency` VARCHAR(15) NOT NULL,
  `client_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`id`, `client_id`),
  UNIQUE INDEX `number_UNIQUE` (`number` ASC) VISIBLE,
  INDEX `fk_count_client_idx` (`client_id` ASC) VISIBLE,
  CONSTRAINT `fk_count_client`
    FOREIGN KEY (`client_id`)
    REFERENCES `BankSystem`.`client` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
GO
CREATE TABLE IF NOT EXISTS `BankSystem`.`card` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `number` VARCHAR(255) NOT NULL,
  `pin` VARCHAR(255) NOT NULL,
  `term` DATE NOT NULL,
  `count_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`id`, `count_id`),
  UNIQUE INDEX `number_UNIQUE` (`number` ASC) VISIBLE,
  INDEX `fk_card_count_idx` (`count_id` ASC) VISIBLE,
  CONSTRAINT `fk_card_count`
    FOREIGN KEY (`count_id`)
    REFERENCES `BankSystem`.`count` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
