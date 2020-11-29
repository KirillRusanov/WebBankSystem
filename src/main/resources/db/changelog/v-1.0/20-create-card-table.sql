CREATE TABLE IF NOT EXISTS card (
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
    REFERENCES count (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
 ENGINE = InnoDB;