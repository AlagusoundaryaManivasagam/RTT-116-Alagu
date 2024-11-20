-- left join-----------------------------------
select c.customer_name, o.id as order_id, c.id as customer_id, o.status
from customers c 
left join orders o on c.id = o.customer_id;

select c.customer_name, o.id as order_id, c.id as customer_id, o.status
from customers c , orders o 
where c.id = o.customer_id
order by c.id;

select c.customer_name, o.id as order_id, c.id as customer_id, o.status
from customers c 
inner join orders o on c.id = o.customer_id
order by c.id;

select c.customer_name, o.id as order_id, c.id as customer_id, o.status
from customers c 
 join orders o on c.id = o.customer_id
 order by c.id;
 
 -- instructors notes
 -- this is the left join syntax for 2 tables
SELECT  c.id as customer_id,  c.customer_name, o.id as order_id, o.status
FROM customers c
LEFT JOIN orders o ON c.id = o.customer_id;

-- this is a regular query (this is an inner join)
SELECT  c.id as customer_id,  c.customer_name, o.id as order_id, o.status
FROM customers c, orders o
where c.id = o.customer_id
order by c.id;

-- this is the same regular query accept using the MySQL syntax 
-- this is the same as above accept using the inner join syntax from mysql
SELECT  c.id as customer_id,  c.customer_name, o.id as order_id, o.status
FROM customers c
INNER JOIN orders o ON c.id = o.customer_id
order by c.id;

-- -----------------------------------------------------------
-- self join
select * from employees;
-- reports to is a foreign key for id in the same table, this is not a official foreign key, this is a self referencing table,so we can use self join
 select e.id, e.lastname, e.firstname, m.id as Manager_id, m.lastname as Manager_lastname, m.firstname as Manager_firstname, m.job_title
 from employees e,employees m
 where e.reports_to = m.id;
 -- ===============UNION ==============
 -- No duplicates
 -- union alll includes duplicates
 select * from customers where customer_name like 'A%'
 union
  select * from customers where customer_name like 'B%';
  
  -- no matter what we choose as long as number of columns are same union works
  -- 0	236	11:34:36	select customer_name from customers where customer_name like 'A%'
  -- union
    -- select phone, customer_name from customers where phone like '6%'	Error Code: 1222. The used SELECT statements have a different number of columns	0.000 sec
  select customer_name from customers where customer_name like 'A%'
  union
   select phone, customer_name from customers where phone like '6%';
   
   select * from productlines pl
   where pl.id not in (select p.productline_id from products p, orderdetails od where p.id = od.product_id);
   
   INSERT INTO `classic_models`.`productlines`
(
`product_line`,
`description`)
VALUES
('Test Line','Just for class');
