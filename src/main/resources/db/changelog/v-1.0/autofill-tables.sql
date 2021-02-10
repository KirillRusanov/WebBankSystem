INSERT INTO client (`address`, `birthday`, `name`, `pass_number`, `patronymic`, `phone_number`, `surname`)
values ("Solomvoi", CURRENT_DATE(), "Max", "A1111111", "Alexandrovich", "E1ARRRRRRR", "Rusanov")
GO
INSERT INTO client (`address`, `birthday`, `name`, `pass_number`, `patronymic`, `phone_number`, `surname`)
values ("Penfif", CURRENT_DATE(), "Dima", "A22222222", "Sergeevich", "E1BFDSSSSSD", "Piterskio")
GO
INSERT INTO client (`address`, `birthday`, `name`, `pass_number`, `patronymic`, `phone_number`, `surname`)
values ("Lanisk", CURRENT_DATE(), "Vasya", "L22222222", "Pavlovich", "E1BDFSDDD", "Kim")
GO
INSERT INTO client (`address`, `birthday`, `name`, `pass_number`, `patronymic`, `phone_number`, `surname`)
values ("Olsha", CURRENT_DATE(), "Piter", "S22222222", "Maximovich", "G3122122DD", "Pozeleyi")
GO
INSERT INTO `count` (`number`, `balance`, `currency`,`client_id`)
 values ("D8000", 900, "BYN", 1)
GO
INSERT INTO `count` (`number`, `balance`, `currency`,`client_id`)
 values ("R2000", 10122, "RUS", 2)
GO
INSERT INTO `count` (`number`, `balance`, `currency`,`client_id`)
 values ("P132", 50, "BYN", 1)
GO
INSERT INTO `count` (`number`, `balance`, `currency`,`client_id`)
 values ("L123", 100000121, "RUS", 2)
GO
INSERT INTO `count` (`number`, `balance`, `currency`,`client_id`)
 values ("D31223", 5000213, "BYN", 1)
GO
INSERT INTO `count` (`number`, `balance`, `currency`,`client_id`)
 values ("e1232dfeqw", 100000, "RUS", 3)
GO
INSERT INTO card (`number`, `pin`, `term`, `count_id`)
 values ("1231-1232-2863-2121", "3211", CURRENT_DATE(), 1)
GO
INSERT INTO card (`number`, `pin`, `term`, `count_id`)
 values ("8765-5123-4214-4124", "3123", CURRENT_DATE(), 2)
GO
INSERT INTO card (`number`, `pin`, `term`, `count_id`)
 values ("2242-1232-1111-2121", "3211", CURRENT_DATE(), 6)
GO
INSERT INTO card (`number`, `pin`, `term`, `count_id`)
 values ("8876-5123-4214-4124", "3123", CURRENT_DATE(), 2)
GO
INSERT INTO card (`number`, `pin`, `term`, `count_id`)
 values ("1231-9999-5323-2121", "3211", CURRENT_DATE(), 6)
GO
INSERT INTO card (`number`, `pin`, `term`, `count_id`)
 values ("1134-5123-4214-4124", "3123", CURRENT_DATE(), 2)
GO
INSERT INTO card (`number`, `pin`, `term`, `count_id`)
 values ("1231-1242-7773-2121", "3211", CURRENT_DATE(), 2)
GO
INSERT INTO card (`number`, `pin`, `term`, `count_id`)
 values ("4241-4223-1224-4129", "3123", CURRENT_DATE(), 2)
GO
INSERT INTO card (`number`, `pin`, `term`, `count_id`)
 values ("1231-1232-2123-2129", "3211", CURRENT_DATE(), 2)
GO
INSERT INTO card (`number`, `pin`, `term`, `count_id`)
 values ("3231-5123-4214-4124", "3123", CURRENT_DATE(), 2)
