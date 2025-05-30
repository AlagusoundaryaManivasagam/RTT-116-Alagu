select * from offices;
select count(*) from offices;
start transaction;
commit;
select count(*) from employees;
select  uuid();
select uuid_short();

insert into offices ( city, phone, address_line1, address_line2, state , country, postal_code, territory)
			values  ( 'NYC', '5555555555' , 'Downtown' , 'address', 'co' , 'USA' , 74012 , 'USA');
            INSERT INTO `classic_models`.`offices`
(
`city`,
`phone`,
`address_line1`,
`address_line2`,
`state`,
`country`,
`postal_code`,
`territory`)
VALUES
(
 'nyc' ,555555555  ,'1','2' ,'nyc','USA' , 34015,'USA');
delete from offices where id = 9;
update offices set phone = '123456789'where id = 8;
select * from employees;
select * from employees where office_id>7;
-- i wantt to see first and last name of all employess and office city they work in --
select firstname, lastname, city,o.id,e.office_id,e.id
from employees e, offices o
where e.office_id = o.id;
-- i want a list of customers for paticular employee
select * from customers where sales_rep_employee_id = 1504;
-- i want to see all customers with thecontact last name cassidy --
select * from customers where contact_lastname= 'Cassidy';
select * from customers where country = 'Ireland';
-- credit limit less than 10K --
select * from customers where credit_limit>10000 and credit_limit<50000; 
-- for whatever reason % is used as a wildcard --
-- any name starting with J --
select * from customers where contact_firstname like '%nn%';
select * from customers where contact_firstname like '%h%';
select * from products;
select * from productlines;
select * from customers where contact_lastname = 'Young';
select* from customers;
select * from orderdetails where order_id =10100;
select * from orders;
select * from employees;
select*from offices;