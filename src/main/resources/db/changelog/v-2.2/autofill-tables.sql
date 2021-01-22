INSERT INTO `client` (`id`, `profilePhoto`, `isVerified`, `email`, `role`, `username`, `password`, `address`, `birthday`, `name`, `pass_number`, `patronymic`, `phone_number`, `surname`)
values (1, "unnamed.jpg", FALSE, "tester@gmail.com", "USER", "Dominik", "$2y$12$CcaLLs/qUA3uAqJpGzKnO.ywTzFmSnPEp6JXj5pUAkwqWwSiqfKNO","Solomvoi", CURRENT_DATE(), "Max", "A1111111", "Alexandrovich", "E1ARRRRRRR", "Rusanov")
GO
INSERT INTO `client` (`id`, `profilePhoto`, `isVerified`, `email`, `role`, `username`, `password`, `address`, `birthday`, `name`, `pass_number`, `patronymic`, `phone_number`, `surname`)
values (2, "unnamed.jpg", FALSE, "Maxin@gmail.com", "USER", "Malich", "$2y$12$NGq9WLiyr7xh2zJosznTWesvEXqjuiCH/wH7WqKaW9uSOkD3Sn3lq", "Penfif", CURRENT_DATE(), "Dima", "A22222222", "Sergeevich", "E1BFDSSSSSD", "Piterskio")
GO
INSERT INTO `client` (`id`, `profilePhoto`, `isVerified`, `email`, `role`, `username`, `password`, `address`, `birthday`, `name`, `pass_number`, `patronymic`, `phone_number`, `surname`)
values (3, "unnamed.jpg", FALSE, "test@gmail.com", "USER", "Nick", "$2y$12$ABiuKf1ZYDDCnkOgM5YEK.FtAiTQF4tiQx5Dvj6ZC5HuLYF8IWFpa", "Lanisk", CURRENT_DATE(), "Vasya", "L22222222", "Pavlovich", "E1BDFSDDD", "Kim")
GO
INSERT INTO `client` (`id`, `profilePhoto`, `isVerified`, `email`, `role`, `username`, `password`, `address`, `birthday`, `name`, `pass_number`, `patronymic`, `phone_number`, `surname`)
values (4, "unnamed.jpg", TRUE, "admin@gmail.com", "ADMIN", "Rusanov", "$2y$12$Pr5njwGcl0Y9wT8ywvJ7POQsrnlPwCy0nEWEJsDN5PvjByX9sjtyq", "Street", CURRENT_DATE(), "Kirill", "PB23DF2321", "Alexandrovich", "+375295840150", "Rusanov")
GO
INSERT INTO `count` (`id`, `number`, `balance`, `currency`,`client_id`)
 values (1, "D8000", 900, "BYN", 4)
GO
INSERT INTO `count` (`id`, `number`, `balance`, `currency`,`client_id`)
 values (2, "R2000", 10122, "RUS", 2)
GO
INSERT INTO `count` (`id`, `number`, `balance`, `currency`,`client_id`)
 values (3, "P132", 50, "BYN", 3)
GO
INSERT INTO `count` (`id`, `number`, `balance`, `currency`,`client_id`)
 values (4, "L123", 100000121, "RUS", 4)
GO
INSERT INTO `count` (`id`, `number`, `balance`, `currency`,`client_id`)
 values (5, "D31223", 5000213, "BYN", 4)
GO
INSERT INTO `count` (`id`, `number`, `balance`, `currency`,`client_id`)
 values (6, "e1232dfeqw", 100000, "RUS", 1)
GO
INSERT INTO card (`id`, `number`, `pin`, `term`, `count_id`)
 values (1, "1231-1232-2863-2121", "3211", CURRENT_DATE(), 1)
GO
INSERT INTO card (`id`, `number`, `pin`, `term`, `count_id`)
 values (2,"8765-5123-4214-4124", "3123", CURRENT_DATE(), 1)
GO
INSERT INTO card (`id`, `number`, `pin`, `term`, `count_id`)
 values (3, "2242-1232-1111-2121", "3211", CURRENT_DATE(), 2)
GO
INSERT INTO card (`id`, `number`, `pin`, `term`, `count_id`)
 values (4, "8876-5123-4214-4124", "3123", CURRENT_DATE(), 3)
GO
INSERT INTO card (`id`, `number`, `pin`, `term`, `count_id`)
 values (5, "1231-9999-5323-2121", "3211", CURRENT_DATE(), 4)
GO
INSERT INTO card (`id`,`number`, `pin`, `term`, `count_id`)
 values (6, "1134-5123-4214-4124", "3123", CURRENT_DATE(), 1)

