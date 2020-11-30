CREATE TABLE IF NOT EXISTS client (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `surname` VARCHAR(255) NOT NULL,
  `patronymic` VARCHAR(255) NOT NULL,
  `address` VARCHAR(255) NOT NULL,
  `pass_number` VARCHAR(255) NOT NULL,
  `birthday` DATE,
  `phone_number` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `pass_number_UNIQUE` (`pass_number` ASC) VISIBLE,
  UNIQUE INDEX `phone_number_UNIQUE` (`phone_number` ASC) VISIBLE)
ENGINE = InnoDB;
GO
INSERT INTO client (`address`, `birthday`, `name`, `pass_number`, `patronymic`, `phone_number`, `surname`)
 values ("Folush", null, "Max", "A1111111", "Alexandrovich", "E1ARRRRRRR", "Rusanov")
GO
INSERT INTO client (`address`, `birthday`, `name`, `pass_number`, `patronymic`, `phone_number`, `surname`)
 values ("Folush", null, "Dima", "A22222222", "Sergeevich", "E1BDDDDDD", "Dolin")

