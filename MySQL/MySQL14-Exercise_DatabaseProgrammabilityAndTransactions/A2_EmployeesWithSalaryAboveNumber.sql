#Create stored procedure usp_get_employees_salary_above
#that accept a decimal number (with precision, 4 digits after the decimal point) as parameter
#and return all employee's first and last names whose salary is above or equal to the given number.
#The result should be sorted by first_name then by last_name alphabetically and id ascending.
#Submit your query statement as Run skeleton, run queries & check DB in Judge.
DELIMITER $$

CREATE PROCEDURE `usp_get_employees_salary_above`(`searched_salary` DECIMAL(10, 4))
BEGIN
    SELECT `first_name`,
           `last_name`
    FROM `employees`
    WHERE `salary` >= searched_salary
    ORDER BY `first_name`, `last_name`, `employee_id`;
END $$

DELIMITER ;

CALL `usp_get_employees_salary_above`(45000);