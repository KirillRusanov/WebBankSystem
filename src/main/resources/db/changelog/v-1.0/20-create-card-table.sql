CREATE TABLE IF NOT EXISTS card (
   `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
    `number` VARCHAR(255) NOT NULL,
    `pin` VARCHAR(255) NOT NULL,
    `term` DATE,
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
GO
INSERT INTO card (`number`, `pin`, `term`, `count_id`)
 values ("1231-1232-2123-2121", "3211", null, 1)
GO
INSERT INTO card (`number`, `pin`, `term`, `count_id`)
 values ("1231-5123-4214-4124", "3123", null, 2)