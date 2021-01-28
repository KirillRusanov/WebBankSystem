CREATE TABLE IF NOT EXISTS `banksystem`.`Transfer` (
    `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
    `fromCard` VARCHAR(255) NOT NULL,
    `toCard` VARCHAR(255) NOT NULL,
    `amount` BIGINT(20) NOT NULL,
    PRIMARY KEY (`id`))
ENGINE = InnoDB;