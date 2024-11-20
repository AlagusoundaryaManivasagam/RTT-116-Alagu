-- lets calculate total profit for an order 10100
select p.product_name,p.buy_price, od.price_each, od.quantity_ordered, (price_each - buy_price) as product_margine ,
 quantity_ordered * (price_each - buy_price) as line_item_margin
from orderdetails od, products p
where od.product_id = p.id
and od.order_id = 10100 ;
-- -----------------------------------------------------------------------------------------------------------------
-- lets calculate the total profit for all orders
select od.order_id, sum(quantity_ordered*( price_each - buy_price)) as total_profit
from orderdetails od, products p
where od.product_id = p.id
group by od.order_id ;

-- total profit for a month
select year(o.order_date), month(o.order_date), sum(quantity_ordered*( price_each - buy_price)) as total_profit
from orders o, orderdetails od, products p
where od.product_id = p.id
and od.order_id= o.id
group by year(order_date), month(o.order_date);

select current_date();
select now();
select * from orders
where order_date <  current_date();

select ifnull(comments, 'Replace comment')
from orders;
-- this is wrong querry
select * from orders where comments = null;
-- this is right
select * from orders where comments is not null;


select * from orders where id <> 10100;
select * from orders where id != 10100;

-- SBA Question
-- like switch statement in java
SELECT product_name, buy_price, 
CASE
	WHEN buy_price > 80 AND buy_price <=  50 THEN "LOW PRICE"
	WHEN buy_price > 50 AND buy_price <= 100 THEN "Medium Price"
	WHEN buy_price > 100 AND buy_price <= 200 THEN "high Price"
ELSE "Out of our rang" END AS price_status 
FROM products 
where buy_price > 9
ORDER BY buy_price DESC;

-- this is like an 'or' 
select * from customers where city in ('Las Vegas', 'Nantes', 'Frankfurt');


-- instead of joining tables we can use sub querry
-- inner querry will be done first then the outer querry
select id from customers where id in (103, 112, 119);
select * from orders where customer_id in(select id from customers where id in (103, 112, 119));

select id from customers where customer_name like 'A%';
select * from orders where customer_id in(select id from customers where customer_name like 'A%');

-- by using subquerry in the from clause creates a table in the memory
-- we can join the table a s it were a real table
select * 
from orders o, (select id from customers where customer_name like 'A%') c
where o.customer_id = c.id;

select o.id, o.order_date from 
orders o ,(select id from customers where customer_name like 'A%') c 
where o.customer_id = c.id
group by o.id, o.order_date ;
