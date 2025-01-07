--Activity 5

--Update the grade score of salesmen from Rome to 200.
UPDATE salesman SET grade = 200 where salesman_city = 'Rome';

--Update the grade score of James Hoog to 300.
UPDATE salesman SET grade = 300 where salesman_name = 'James Hoog';

--Update the name McLyon to Pierre.
UPDATE salesman SET salesman_name = 'Pierre' where salesman_name = 'Mclyon';

--Display modified data
SELECT * FROM salesman;