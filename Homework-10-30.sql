-- which product did we sell most of ? i would like to see the number of orders,total amount sold, product name
select p.product_name , count(od.order_id), sum(od.quantity_ordered)
from orderdetails od, products p 
where od.product_id = p.id
group by od.product_id 
order by count(od.order_id)desc;

select p.product_name , od.order_id, od.quantity_ordered
from orderdetails od, products p 
where od.product_id = p.id
order by od.order_id desc;


-- which product generated the most profit by year.  In the result I want to see the year, the product name, and the total profit.  order by year desc, profit desc
select year(o.order_date), p.product_name, sum(od.quantity_ordered*(od.price_each - p.buy_price)) as profit
from orderdetails od, products p, orders o
where od.product_id = p.id
and od.order_id = o.id
group by year(o.order_date), od.product_id
order by year(o.order_date) desc, profit desc ; 

-- Optional: which office is the most profitable?   result should show the name of the office and the total profit for that office orderd by profit descending
select o.city, sum(od.quantity_ordered*(od.price_each - p.buy_price )) as profit
from offices o, employees e, customers c, orders ord, orderdetails od , products p
where e.office_id = o.id
and c.sales_rep_employee_id = e.id
and ord.customer_id= c.id
and od.order_id = ord.id
and od.product_id = p.id
group by city
order by profit desc;

-- Optional:  Show me all the customers that have an outstanding balance due... 
-- would have to sum the payments for the customer and compare the total amount paid to the total amount purchased.
select c.customer_name, sum(od.quantity_ordered * od.price_each) as amount_purchased, sum(p.amount) as amount_paid
from customers c, payments p, orders o, orderdetails od
where p.customer_id = c.id
and o.customer_id = c.id
and od.order_id = o.id
group by o.customer_id
having amount_purchased <= amount_paid;

select o.customer_id, sum(od.quantity_ordered*od.price_each)
from orders o, orderdetails od
where o.id = od.order_id
group by o.customer_id;

select c.id, sum(p.amount) as amountPaid, sum(od.quantity_ordered*od.price_each) as billAmount
from customers c, payments p, orders o, orderdetails od
where p.customer_id = c.id
and o.customer_id = c.id
and o.id = od.order_id
group by c.id
having amountPaid<billAmount;

