--Activity 7-
--Write an SQL statement to find the total purchase amount of all orders.
SELECT SUM(purchase_amount) AS "Total Sum" from orders;
    
--Write an SQL statement to find the average purchase amount of all orders.
SELECT AVG(purchase_amount) AS "Average" from orders;
    
--Write an SQL statement to get the maximum purchase amount of all the orders.
SELECT MAX(purchase_amount) AS "Maximum" from orders;
    
--Write an SQL statement to get the minimum purchase amount of all the orders.
SELECT MIN(purchase_amount) AS "Minimum" from orders;
    
--Write an SQL statement to find the number of salesmen listed in the table.
SELECT COUNT(salesman_id) AS "Count" from orders;