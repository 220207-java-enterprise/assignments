-- 2.1 select 
--Task 每 Select all records from the Employee table.
select * from  "Employee";
--Task 每 Select all records from the Employee table where last name is King.
select * from  "Employee" where "LastName" = 'King' ;
--Task 每 Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
select * from  "Employee" where "FirstName" = 'Andrew' and "ReportsTo" is null;

-- 2.2 order by 
--Task 每 Select all albums in album table and sort result set in descending order
select * from  "Album" order by "Title"  desc ; --descending order
--Task 每 Select first name from Customer and sort result set in ascending order
select "FirstName" from "Customer" order by "FirstName"; --ascending order by default

--2.3 insert into 
--Task 每 Insert two new records into Genre table
insert into  "Genre" ("GenreId", "Name") VALUES (26, N'Walter');
insert into  "Genre" ("GenreId", "Name") VALUES (27, N'Mark');
select * from  "Genre";
--Task 每 Insert two new records into Employee table
insert into "Employee" ("EmployeeId", "LastName","FirstName")VALUES (9,N'Laurie', N'Box');
insert into "Employee" ("EmployeeId", "LastName","FirstName")VALUES (10,N'Brinda ', N'Altman');
select * from  "Employee";
--Task 每 Insert two new records into Customer table
insert  into "Customer" ("CustomerId","FirstName","LastName","Email")VALUES (60,N'Laurie', N'Box','Laurie@gamil.com');
insert  into "Customer" ("CustomerId","FirstName","LastName","Email")VALUES (61,N'Brinda ', N'Altman','Brinda@gamil.com');
select *from "Customer"; 

--2.4 update  
--Task 每 Update Aaron Mitchell in Customer table to Robert Walter
update "Customer" 
set "FirstName" ='Robert', "LastName" = 'Walter'
where "CustomerId" = 32;
--Task 每 Update name of artist ※Creedence Clearwater Revival§ to ※CCR§
update "Artist" 
set "Name" = 'CCR'
where "ArtistId" = 76;

--2.5 like
--Task 每 Select all invoices with a billing address like ※T§
select * from "Invoice" where "BillingAddress" like '%T%';
/*
 'a%':start with "a";  '%a':end with "a"; '%a%':have "or" in any position
 */

--2.6 between
--Task 每 Select all invoices that have a total between 15 and 50
select * from "Invoice" where "Total" between 15 and 50;
--Task 每 Select all employees hired between 1st of June 2003 and 1st of March 2004
select * from "Employee" where "HireDate" between '06/01/2003' and '03/01/2004'; 

--2.7 delete 
--Task 每 Delete a record in Customer table where the name is Robert Walter
delete from "Customer" where "FirstName" ='Robert' and "LastName" ='Walter' and "CustomerId" = 32; 
select * from "Customer" where "FirstName" = 'Robert';
select * from "Invoice" where "CustomerId" = 32;
/*update "Invoice" 
set "CustomerId"  = 9999;
where "CustomerId" = 32;*/
delete from  "Invoice" where "CustomerId" =32;
select * from  "InvoiceLine" where "InvoiceId" =50;
delete from "InvoiceLine" where "InvoiceId" =50;



--4.1 inner
--Task 每 Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
select "Customer"."FirstName","Customer"."LastName","Invoice"."InvoiceId"  
from  "Customer" inner join "Invoice" 
on "Customer"."CustomerId" = "Invoice"."CustomerId"
order by "FirstName";

--4.2 outer
--Task 每 Create an outer join that joins the customer and invoice table, 
--specifying the CustomerId, firstname, last name, invoiceId, and total.
select "Customer"."CustomerId","Customer"."FirstName","Customer"."LastName", "Invoice"."InvoiceId", "Invoice"."Total"
from "Customer" full outer join "Invoice"
on "Customer"."CustomerId" = "Invoice"."CustomerId"
order by "CustomerId";

--4.3 right join 
--Task 每 Create a right join that joins album and artist specifying artist name and title.
select "Album"."Title", "Artist"."Name"
from "Album" right join "Artist"
on "Album"."ArtistId" = "Artist"."ArtistId"
order by "Name";

--4.4 cross join 
--Task 每 Create a cross join that joins album and artist and sorts by artist name in ascending order.
select * from "Album" cross join "Artist" order by "Name";

--4.5 self join 
--A self join is a regular join, but the table is joined with itself.
--Task 每 Perform a self-join on the employee table, joining on the reports to column.
select "Employee"."ReportsTo" from "Employee";









/*3.0 SQL Functions
In this section you will be using the PostGreSQL system functions, as well as your own functions, to perform various actions against the database

3.1 System Defined Functions
Task 每 Create a query that leverages a system-defined function to return the current time.

Task 每 Create a query that leverages a system-defined function to return the length of a mediatype from the mediatype table

3.2 System Defined Aggregate Functions
Task 每 Create a query that leverages a system-defined function to return the average total of all invoices

Task 每 Create a query that leverages a system-defined function to return the most expensive track

3.3 User Defined Scalar Functions
Task 每 Create a function that returns the average price of invoice-line items in the invoice-line table

3.4 User Defined Table Valued Functions
Task 每 Create a function that returns all employees who are born after 1968.
*/


