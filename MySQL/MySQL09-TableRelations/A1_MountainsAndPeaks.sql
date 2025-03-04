#Write a query to create two tables – mountains and peaks and link their fields properly. Tables should have:
#- Mountains:
#· id
#· name
#- Peaks:
#· id
#· name
#· mountain_id
#Check your solutions using the "Run Queries and Check DB" strategy.
CREATE TABLE `mountains`
(
    `id`   INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(50) NOT NULL
);

CREATE TABLE `peaks`
(
    `id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(50) NOT NULL,
    `mountain_id` INT NOT NULL,
    CONSTRAINT `fk_peaks_mountains`
    FOREIGN KEY (`mountain_id`)
    REFERENCES `mountains`(`id`)
);