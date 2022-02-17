create table postgres.chinook.test();
drop table test;
tables view;


--2.1 SELECT
--Task – Select all records from the Employee table.
select * from postgres.chinook."Employee";

--Task – Select all records from the Employee table where last name is King.
select * from "Employee" where "LastName" like 'King';

--Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
select * from "Employee" where "FirstName" like 'Andrew' and "ReportsTo" is null;

--2.2 ORDER BY
--Task – Select all albums in album table and sort result set in descending order
select * from "Album";
select * from "Album" order by "Title" desc;

--Task – Select first name from Customer and sort result set in ascending order
select "FirstName" from "Customer" order by "FirstName" asc;

--2.3 INSERT INTO
--Task – Insert two new records into Genre table
select * from "Genre";

insert into "Genre" 
values (26, 'RapRap');

insert into "Genre" ("GenreId", "Name")
values (27, 'SnakeJazz');

--Task – Insert two new records into Employee table
select * from "Employee";

insert into "Employee"
values (9, 'Doe', 'John', 'Wannabe', 6, '1968-01-09', '2003-09-01', '321 4 st st', 'Tampa, FL', 'US', 33605, 8135083211, 812383201, 'abc@gmail.com');

insert into "Employee"
values (10, 'Do', 'Joh', 'Wannab', 6, '1968-01-08', '2003-09-08', '321 4 st st', 'Tampa, FL', 'US', 3365, 813503218, 81233208, 'abcd@gmail.com');

--Task – Insert two new records into Customer table
select * from "Customer";

insert into "Customer"
values (60, 'Do', 'Joh', 'some', 6, 'Tampa', 'FL', 'US', 3365, 813503218, 81233208, 'abcd@gmail.com', 3);

insert into "Customer"
values (61, 'Doe', 'Johe', 'some', 6, 'Tampa', 'FL', 'US', 3365, 813503218, 81233208, 'abcd@gmail.com', 3);

--2.4 UPDATE
--Task – Update Aaron Mitchell in Customer table to Robert Walter
select * from "Customer" where "FirstName" = 'Aaron';

UPDATE "Customer"
SET "FirstName" = 'Robert', "LastName" = 'Walter'
WHERE "FirstName" = 'Aaron';

select * from "Customer" where "FirstName" = 'Robert';

--Task – Update name of artist “Creedence Clearwater Revival” to “CCR”
select * from "Artist";

update "Artist"
set "Name" = 'CCR'
where "Name" = 'Creedence Clearwater Revival';

--2.5 LIKE
--Task – Select all invoices with a billing address like “T”
select * from "Invoice";
select * from "Invoice" where "BillingAddress" like 'T%';

--2.6 BETWEEN
--Task – Select all invoices that have a total between 15 and 50
select * from "Invoice";
select * from "Invoice" where "Total" between 15 and 50;


--Task – Select all employees hired between 1st of June 2003 and 1st of March 2004
select * from "Employee";
select * from "Employee" where "HireDate" between '2003-06-1' and '2004-03-1';

--2.7 DELETE
--Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).
select * from "Customer";

ALTER TABLE "Invoice" DROP 
   CONSTRAINT "FK_InvoiceCustomerId";
  
--  alter table "Invoice"
--drop constraint "FK_InvoiceCustomerId";
--
--alter table "Invoice"
--add constraint "FK_InvoiceCustomerId"
--foreign key ("CustomerId")
--references "Customer"("CustomerId")
--on delete cascade;
--
--alter table "InvoiceLine"
--drop constraint "FK_InvoiceLineInvoiceId";
--
--alter table "InvoiceLine"
--add constraint "FK_InvoiceLineInvoiceId"
--foreign key ("InvoiceId")
--references "Invoice"("InvoiceId")
--on delete cascade;

delete from "Customer" where "FirstName"='Robert' and "LastName"='Walter';


delete from "Customer" where "FirstName" = 'Robert' and "LastName" = 'Walter';

--3.0 SQL Functions
--In this section you will be using the PostGreSQL system functions, as well as your own functions, to perform various actions against the database

--3.1 System Defined Functions
--Task – Create a query that leverages a system-defined function to return the current time.
select CURRENT_TIMESTAMP;

--Task – Create a query that leverages a system-defined function to return the length of a mediatype from the mediatype table
select * from "MediaType" mt;


--select len("Name") from "MediaType" mt;
--skip 3 go to 4

--4.0 JOINS
--In this section you will be working with combining various tables through the use of joins. You will work with outer, inner, right, left, cross, and self joins.

--4.1 INNER
--Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
select * from "Customer" 
inner join "Invoice" 
on "Customer"."CustomerId" = "Invoice"."InvoiceId";

select concat("Customer"."FirstName", ' ', "Customer"."LastName") as customer_name, "Invoice"."InvoiceId"
from "Customer"
inner join "Invoice"
on "Customer"."CustomerId" = "Invoice"."CustomerId";


--4.2 OUTER
--Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, last name, invoiceId, and total.
select "Customer"."CustomerId", "Customer"."FirstName", "Customer"."LastName", "Invoice"."InvoiceId", "Invoice"."Total" from "Customer" 
full outer join "Invoice" 
on "Customer"."CustomerId" = "Invoice"."InvoiceId";

--4.3 RIGHT
--Task – Create a right join that joins album and artist specifying artist name and title.
select * from "Album";
select * from "Artist";

select "Name", "Title" from "Album" 
right join "Artist" 
on "Album"."AlbumId" = "Artist"."ArtistId";

--4.4 CROSS
--Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
select * from "Album";
select * from "Artist";

select "Name", "Title" from "Album" 
cross join "Artist";

--4.5 SELF
--Task – Perform a self-join on the employee table, joining on the reports to column.
select * from "Employee";

SELECT "Employee"."ReportsTo"
FROM "Employee";

