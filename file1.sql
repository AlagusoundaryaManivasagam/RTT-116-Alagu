-- how many employees in each office --
-- office name and count of employees in office --
-- join and group by --
select* from employees;
-- group by is aggregate function which makes a group andfinds information about that group -- 
-- create aliases when more than one table is involved --
select office_id, count(*) from employees
group by office_id;

-- add another column from another table and create a link between them --
select o.city, e.office_id, count(*)from offices o, employees e
where e.office_id = o.id
group by office_id;
select firstname , count(*) from employees
group by firstname;

-- employees with most customer --
select sales_rep_employee_id, count(*) 
from customers
group by sales_rep_employee_id
order by count(*)desc;
-- adding employee name  from the employee table --
select* from employees;
select e.firstname, e.lastname , c.sales_rep_employee_id, count(*) 
from customers c, employees e
where e.id = c. sales_rep_employee_id
group by sales_rep_employee_id
order by count(*)desc;

-- all customers from san francisco office --
select e.firstname, e.lastname, o.city ,c.customer_name, c.contact_firstname, c.contact_lastname
from offices o, employees e, customers c
where o.id = 1
and e.office_id = o.id
and c.sales_rep_employee_id = e.id; 
-- all customers that made an order, customer name , office, employee name , order id and order date--
select e.firstname, e.lastname, o.city ,c.customer_name, c.contact_firstname, c.contact_lastname, ord.id as order_id,ord.order_date
from offices o, employees e, customers c, orders ord
where e.office_id = o.id
and c.sales_rep_employee_id = e.id
and ord.customer_id= c.id
order by e.id, customer_name; 
-- i want to see the list of all products purchased , i want to see the customer name, the employee name, order date, and product id and quantity ordered --
select * from orderdetails;
select e.firstname, e.lastname, o.city ,c.customer_name, c.contact_firstname, c.contact_lastname, ord.id as order_id,ord.order_date, od.product_id, od. quantity_ordered
from offices o, employees e, customers c, orders ord, orderdetails od
where e.office_id = o.id
and c.sales_rep_employee_id = e.id
and ord.customer_id= c.id
and od.order_id = ord.id
order by e.id, customer_name; 
-- I want to see everything from the previuos report and add prduct name --
select * from products;
-- three steps to join --
-- add it to the from clause
-- add it to the where clause
-- add it to the select statement
select e.firstname, e.lastname, o.city ,c.customer_name, c.contact_firstname, c.contact_lastname, ord.id as order_id,ord.order_date, od.product_id, od. quantity_ordered, p.product_name
from offices o, employees e, customers c, orders ord, orderdetails od, products p
where e.office_id = o.id
and c.sales_rep_employee_id = e.id
and ord.customer_id= c.id
and od.order_id = ord.id
and od.product_id = p.id
order by e.id, customer_name, order_id, product_name; 
-- all products that have been ordered 
select od.order_id as order_number, count(*)
from products p, orderdetails od
where od.product_id = p.id
group by od.order_id
order by order_id; 
-- 1) I want to see the name of the product line and allproduct names in that product line 
-- order by the product line name and then by the product name
  