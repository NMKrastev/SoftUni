INSERT INTO `coaches`(`first_name`, `last_name`, `salary`, `coach_level`)
SELECT `first_name`,
       `last_name`,
       salary * 2,
       CHAR_LENGTH(`first_name`)
FROM `players` AS p
WHERE p.age >= 45;