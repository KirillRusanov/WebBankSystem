INSERT INTO client (`address`, `birthday`, `name`, `pass_number`, `patronymic`, `phone_number`, `surname`)
values ("Folush", null, "Max", "A1111111", "Alexandrovich", "E1ARRRRRRR", "Rusanov")
GO
INSERT INTO client (`address`, `birthday`, `name`, `pass_number`, `patronymic`, `phone_number`, `surname`)
values ("Folush", null, "Dima", "A22222222", "Sergeevich", "E1BDDDDDD", "Dolin")
GO
INSERT INTO `count` (`number`, `balance`, `currency`,`client_id`)
 values ("D8000", 5000, "BYN", 1)
GO
INSERT INTO `count` (`number`, `balance`, `currency`,`client_id`)
 values ("R2000", 100000, "RUS", 2)
GO
INSERT INTO card (`number`, `pin`, `term`, `count_id`)
 values ("1231-1232-2123-2121", "3211", null, 1)
GO
INSERT INTO card (`number`, `pin`, `term`, `count_id`)
 values ("1231-5123-4214-4124", "3123", null, 2)
