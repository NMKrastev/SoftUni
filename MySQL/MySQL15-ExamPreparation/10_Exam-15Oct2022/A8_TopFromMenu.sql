SELECT p.`id`,
       p.`name`,
       COUNT(op.`product_id`) AS `count`
FROM products AS p
         JOIN `orders_products` AS op ON p.`id` = op.`product_id`
GROUP BY p.`name`
HAVING `count` >= 5
ORDER BY `count` DESC,
         p.`name`;