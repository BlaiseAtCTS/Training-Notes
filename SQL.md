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

## CONSTRAINTS:
Where, Between .. AND, Not Between .. AND, !=.

Like "ABC", Not LIKE: %AT%, AN_
```
SELECT title, director FROM movies 
WHERE title LIKE "Toy Story%";

(col used in like or = dont have to be in select)
Comparing String we can use Like or =: (= is case sensitive tho)
select title from movies
where director like "John Lasseter"
```
IN("A", "B"), NOT IN

Limit, Offset

DISTINCT for 2 columns:
```
select distinct b.building_name, e.role from buildings b
left join employees e
on b.building_name = e.building
```

IS / IS NOT NULL

select city, count(customer_name) from customers --> here customer_name as to be inside aggregate func
group by city

select * from employees
where revenue_generated < 
(select avg(revenue_generated) from employees where employees.department = )

Correlation Subqueries:
```
SELECT *
FROM employees
WHERE salary > 
   (SELECT AVG(revenue_generated)
    FROM employees AS dept_employees
    WHERE dept_employees.department = employees.department);
```

```
SELECT
  e.name,
  e.department,
  e.revenue_generated,
  d.avg_dept_revenue
FROM
  employees AS e
JOIN
  (
    -- Non-correlated subquery calculates average revenue for ALL departments
    SELECT
      department,
      AVG(revenue_generated) AS avg_dept_revenue
    FROM
      employees
    GROUP BY
      department
  ) AS d
  ON e.department = d.department -- Join is on the department field
WHERE
  e.revenue_generated < d.avg_dept_revenue;
```