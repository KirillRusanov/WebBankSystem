CREATE TABLE IF NOT EXISTS `banksystem`.`confirmationToken` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `token` VARCHAR(255) NOT NULL,
  `createdDate` DATE,
  `client_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`id`),
    FOREIGN KEY (`client_id`)
    REFERENCES client (`id`))
ENGINE = InnoDB;
GO
DELETE FROM `banksystem`.`card`;
GO
DELETE FROM `banksystem`.`count`;
GO
DELETE FROM `banksystem`.`client`;
GO
ALTER TABLE `client` ADD `email` VARCHAR(255) NOT NULL
GO
ALTER TABLE `client` ADD `isVerified` BIT NOT NULL
GO