CREATE TABLE IF NOT EXISTS count (
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
     REFERENCES client (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
GO
INSERT INTO count (`number`, `balance`, `currency`,`client_id`)
 values ("D8000", 5000, "BYN", 1)
GO
INSERT INTO count (`number`, `balance`, `currency`,`client_id`)
 values ("R2000", 100000, "RUS", 2)