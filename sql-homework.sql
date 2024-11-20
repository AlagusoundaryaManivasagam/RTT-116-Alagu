-- 1) I want to see the name of the product line and all product names in that product line
-- order by the product line name then by the product name
select * from productlines;
select * from products;
select pl.product_line, p.product_name
from productlines pl, products p
where p.productline_id = pl.id
order by pl.product_line, p.product_name;

-- 2) I want to see the order number, the product name, and the quantity ordered
-- order by the order number (descending), then the product name (ascending) , then the quantity ordered ( fewest first)
select * from orders;
select * from orderdetails;
select * from products;
select od.order_id, p.product_name, od.quantity_ordered
from orderdetails od, products p
where od.product_id = p.id
order by od.order_id desc, p.product_name asc, od.quantity_ordered asc;

-- 3) I want to see all payments made by customers.  The result should show the customer name, the check number, payment date, and the amount.  
--  I want the result set ordered by the customer name (ascending), the payment date ( descending  newest first)
select * from customers;
select * from payments;
select c.customer_name, p.check_number, p.payment_date, p.amount
from customers c, payments p 
where p.customer_id = c.id
order by c.customer_name asc, p.payment_date desc;

-- 4) I want to see the orders and all products in that order - order number and product name
-- order by the order number ascending and the product name descending.
select * from orders;
select * from orderdetails;
select * from products;
select od.order_id, p.product_name
from orderdetails od, products p 
where od.product_id= p.id
order by od.order_id asc, p.product_name desc;

-- 5) I want to see the number of products in each order -  I want to see the order id and the count of each product in that order ... order by count(*) desc

select od.order_id, count(*) 
from orderdetails od
group by od.order_id
order by count(*)desc;

-- 6) I want to see the customer that has made most payments (group by customer_id)
select* from payments;
select customer_id, count(*) as count
from payments
group by customer_id
order by count(*)desc;

select customer_id, count(*) as count
from payments
group by customer_id
order by count desc;

-- order by column number is not best practise
select customer_id, count(*) as count
from payments
group by customer_id
order by 2 desc;

-- 7) I want to see the office that has has the most orders (group by office_id)
-- group by primary key we can get individual data

-- gathers all data without group by and use where clause
-- then group by
-- then having
select  o.city, year(od.order_date), count(*), count(distinct e.id), count(distinct c.id)
from orders od, customers c, employees e, offices o 
where od.customer_id = c.id 
and c.sales_rep_employee_id = e.id
and e.office_id = o.id
-- and year(od.order_date) = 2003 and month(od.order_date) = 6
-- no aggregate function in where clause
-- but we can
group by o.id, year(od.order_date)
-- having can only be used with group by
-- having count(distinct e.id)>1
order by count(*)desc;
-- ------------------------------------------------------------------
-- Instructors code
-- when the database executes the query .. internally first it gathers all the data without the group by and using the where clause
-- then it does the group by and figures out the aggregate functions
-- then it applys the having
select o.id, o.city, year(ord.order_date), count(distinct e.id) as employees, count(distinct c.id) as customer_count, count(*) as order_count
from offices o, employees e, customers c, orders ord
where o.id = e.office_id
	and e.id = c.sales_rep_employee_id
    and c.id = ord.customer_id
    -- we can not use aggregate functions in the where clause - this is a good rule of thumb
    -- however we can use the raw data to limit the query before it does the aggregate function
    -- and year(ord.order_date) = 2003 and month(ord.order_date) = 6
   -- and c.customer_name LIKE 'A%'
group by o.id, year(ord.order_date)
-- having is very much like a where clause accept that it only works on the aggrgate functions
-- can only be used with group by statements
-- having count(distinct e.id) > 1
order by o.id asc, year(ord.order_date) desc;

-- ------------------------------------------------------
select order_date, year(order_date), month(order_date) from orders;
-- ------------------------------------------------------

-- 8) I want to see the order that has the most products ( group by order_id)
select order_id, count(*)  
from orderdetails
group by order_id
order by count(*) desc;
select * from orderdetails;

-- 9) BONUS .... I want to see the total quantity ordered for each order ... we have not learned this yet .. but it group by the order_id and sum(quanity_ordered)
-- group by foreign key i.e why only aggregate functions can be used
select order_id, count(*), sum(quantity_ordered), max(quantity_ordered), min(quantity_ordered), max(price_each), min(price_each), avg(price_each)
from orderdetails
group by order_id
order by count(*) desc;


-- 10) I want to see the employee first name and last name and the customer name 
-- ordered by the customer name
select* from employees;
select* from customers;
select e.firstname, e.lastname, c.customer_name
from employees e, customers c 
where c.sales_rep_employee_id = e.id
order by customer_name;

-- 11) I want to see the count of all orders by office
select  o.city,count(*)
from orders od, customers c, employees e, offices o 
where od.customer_id = c.id 
and c.sales_rep_employee_id = e.id
and e.office_id = o.id
group by office_id
order by count(*);

-- ---------------------------
select sum(quantity_ordered* price_each)
from orderdetails;


