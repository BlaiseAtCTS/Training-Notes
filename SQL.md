# SQL Notes
Can learn on SQL Bolt

Oracle DB and MySQL Server might have different syntax.
RENAME is used in oracle databases, but not in MySQL.
```
ALTER TABLE table_name RENAME COLUMN old_column_name TO new_column_name;
The RENAME COLUMN clause is supported from MySQL 8.0 onwards. For earlier versions, use the CHANGE clause.
ALTER TABLE table_name CHANGE old_column_name new_column_name VARCHAR(20);
```

### DATE:
YEAR(publication_date) --> gives year only.

### As a string:
SELECT CONCAT('The Author ', author_name, ' published ', book_name, ' on ', YEAR(published_year)); --> gives a string The Author Adam published Fairy Tale on 2014

### SCALAR and AGGREGATE functions:
SELECT FORMAT(date, 'MMMM') AS Result;
SELECT MONTHNAME(date) AS Result;
https://database.guide/3-ways-to-get-the-month-name-from-a-date-in-sql-server-t-sql/
ROUND(PRICE, 0)

### Group By:
Having --> Its like WHERE but for Group By

### ifnull:
ifnull(price, quantity)

# QUESTIONS:
Purchase Price Based On Customer:
Write a query to display the customer ID, day name of purchase, and total amount paid by all the customers whose average amount paid is less than 10000.

Give an alias name as 'DAY_OF_PURCHASE' for the day name of purchase and 'TOTAL_PRICE' for the total amount paid. Round off the total amount paid to zero decimal places.

Sort the records based on TOTAL_PRICE in descending order.