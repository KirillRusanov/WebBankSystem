DELETE FROM `banksystem`.`card`;
GO
DELETE FROM `banksystem`.`count`;
GO
DELETE FROM `banksystem`.`client`;
GO
ALTER TABLE `client` ADD `username` VARCHAR(255) NOT NULL
GO
ALTER TABLE `client` ADD CONSTRAINT `username_UNIQUE` UNIQUE (`username`)
GO
ALTER TABLE `client` ADD `password` VARCHAR(255) NOT NULL
GO
ALTER TABLE `client` ADD `role` VARCHAR(255) NOT NULL