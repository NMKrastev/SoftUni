#Write a query that selects:
#• employee_id
#• first_name
#• project_name
#Filter only employees with a project, which has started after 13.08.2002 and it is still ongoing (no end date).
#Return the first 5 rows sorted by first_name then by project_name both in ascending order.
SELECT e.`employee_id`,
       e.`first_name`,
       p.`name` AS `project_name`
FROM `employees` AS e
         JOIN `employees_projects` AS ep
              ON ep.`employee_id` = e.`employee_id`
         JOIN `projects` AS p
              ON p.`project_id` = ep.`project_id`
WHERE DATE(p.`start_date`) > '2002-08-13'
  AND p.`end_date` IS NULL
ORDER BY e.`first_name`, p.`name`
LIMIT 5;