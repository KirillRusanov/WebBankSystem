DELETE FROM `banksystem`.`card`;
GO
DELETE FROM `banksystem`.`count`;
GO
DELETE FROM `banksystem`.`client`;
GO
ALTER TABLE `client` ADD `profilePhoto` VARCHAR(255) NOT NULL
GO