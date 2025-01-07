--Activity 11
--Write a query that produces the name and number of each salesman and each customer with more than one current order. Put the results in alphabetical order.
SELECT customer_name, customer_id FROM customers a
WHERE 1<(SELECT COUNT(*) FROM orders b WHERE a.customer_id = b.customer_id)
UNION
SELECT salesman_name, salesman_id FROM salesman c
WHERE 1<(SELECT COUNT(*) FROM orders b WHERE c.salesman_id = b.salesman_id)
ORDER BY customer_name;

--Write a query to make a report of which salesman produce the largest and smallest orders on each date. Also add a column that shows "highest on" and "lowest on" values.
SELECT a.salesman_id, a.salesman_name, b.order_no, 'highest on', b.order_date FROM salesman a, orders b
WHERE a.salesman_id=b.salesman_id
AND b.purchase_amount=(SELECT MAX(purchase_amount) FROM orders c WHERE c.order_date = b.order_date)
UNION
SELECT a.salesman_id, a.salesman_name, b.order_no, 'lowest on', b.order_date FROM salesman a, orders b
WHERE a.salesman_id=b.salesman_id
AND b.purchase_amount=(SELECT MIN(purchase_amount) FROM orders c WHERE c.order_date = b.order_date);