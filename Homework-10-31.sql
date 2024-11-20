-- I want to see all the employees that do not have any customers - subquery using not in
select id as employees_with_no_customer
from employees
where id not in(select sales_rep_employee_id 
from customers
group by sales_rep_employee_id);

select sales_rep_employee_id 
from customers
group by sales_rep_employee_id;



-- I want to see all the customers that have not made an order - subquery using not in
select id as customers_with_no_orders
from customers 
where id not in (select customer_id 
from orders 
group by customer_id);

select customer_id 
from orders 
group by customer_id;

select c.id , o.customer_id
from customers c
left join orders o on c.id = o.customer_id;

select customer_id 
from orders 
group by customer_id;


-- I want to see all of the products that have never been ordered - subquery using not in


-- I want to see all customers that have made an order that has more than 3 products in the order regardless of quantity -  I think this can be done using a subquery in the having

-- I want to see any customer that has made an order greater than $50,000 - this subquery in having

-- I want to see all orders and the number of products in that order and the total number of quantity ordered for that order .. 
-- HOWEVER .. I want the product count and the total quantity order done as subqueries in the select statement.    Do not use a  group by in the outer query

-- Using a subquery as a table ... first create a query that shows the total number of orders by year .. group by year as a subtable.   
--  And a second subtable query the total sales by year ...    Then join both of these tables on year .. and the final output should be ... year, total orders, total sales orderd by year 