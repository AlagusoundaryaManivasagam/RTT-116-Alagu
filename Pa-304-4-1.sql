-- 1) Display the name, product line, and buy price of all products. 
-- The output columns should display as: “Name,” “Product Line,” and “Buy Price.” The output should display the most expensive items first.
select * from productlines;
select * from products;
select p.product_name as 'NAME', pl.product_line as 'Product Line', p.buy_price as 'Buy Price'
from productlines pl, products p 
where p.productline_id = pl.id
order by p.buy_price desc;

-- Display the first name, last name, and city name of all customers from Germany.
-- The output columns should display as: “First Name,” “Last Name,” and “City.” The output should be sorted by “Last Name” (ascending).
select contact_firstname as 'First Name' , contact_lastname as 'Last Name', city as 'City'
from customers
where country = 'Germany';

-- 3)Display each of the unique values of the status field in the orders table. The output should be sorted alphabetically, ascending.
-- Hint: The output should show exactly six rows.
select distinct status
from orders; 

-- 4)Display all fields from the payments table for payments made on or after January 1, 2005. The output should be sorted by the payment date from highest to lowest.
select * 
from payments
where year(payment_date) >= 2005
and month(payment_date) >= 01
and date(payment_date) >= 01;

-- 5)Display the last Name, first Name, email address, and job title of all employees working out of the San Francisco office. The output should be sorted by “Last Name.”
select * from offices;

select e.lastname, e.firstname, e.email, e.job_title, o.city
from employees e, offices o 
where e.office_id = o.id
and o.city =  'San Francisco'
order by e.lastname ;

-- 6)Display the name, product line, scale, and vendor of all of the car products – both classic and vintage.
--  The output should display all vintage cars first (sorted alphabetically by name), and all classic cars last (also sorted alphabetically by name). 
select * from products;
select * from productlines;

select p.product_name, pl.product_line, p.product_scale, p.product_vendor
from products p,  productlines pl
where  p.productline_id = pl.id
and  pl.product_line = 'Vintage Cars'or pl.product_line= 'Classic Cars'
order by pl.product_line desc, p.product_name asc ;
