--2.0 SQL Queries
--In this section you will be performing various queries against the PostgreSQL Chinook database.
--
--2.1 SELECT
--Task – Select all records from the Employee table.

select * from Employee;

--Task – Select all records from the Employee table where last name is King.

select * from "Employee" e  where "LastName" ='King';

--Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.

select * from "Employee" e where e."FirstName" ='Andrew' and "ReportsTo" is null ;

--2.2 ORDER BY
--Task – Select all albums in album table and sort result set in descending order

select * from "Album" a order by "Title"  desc ;

--Task – Select first name from Customer and sort result set in ascending order

select "FirstName" from "Customer" c order by c."FirstName" asc;

--2.3 INSERT INTO
--Task – Insert two new records into Genre table


insert into "Genre" values(26, 'Country');
insert into "Genre" values(27, 'Punk');
)

--Task – Insert two new records into Employee table
insert into "Employee" values(9, 'Jones', 'Indiana', 'Professor', 1, date '1899-07-01', date '2011-03-03', '1234 Fruitloops Way', 'Disneyland', 'CA', 'United States', '93452', '+1 (532) 213-4567', null, 'indijones@gmail.com');
insert into "Employee" values(10, 'Messi', 'Lionel', 'Assistant Professor', 9, date '1989-07-01', date '2016-04-01', '344 Marvin Ave', 'Tampa', 'FL', 'United States', '33552', '+1 (242) 256-4427', null, 'leomessi@gmail.com');
--Task – Insert two new records into Customer table
select * from "Customer" c ;
insert into "Customer" values (60, 'Abhilekh', 'Adhikari', null, '5 Fox Run Rd', 'Raymond', 'NH', 'United States', '03077', '+1(682) 563-3566', null, 'abhilekhadhikari@aol.com', 4);
insert into "Customer" values (61, 'Abhishek', 'Adhikari', null, '5 Fox Run Rd', 'Raymond', 'NH', 'United States', '03077', '+1(682) 467-2346', null, 'abhishekadhikari@gmail.com', 3);
--2.4 UPDATE
--Task – Update Aaron Mitchell in Customer table to Robert Walter
select * from "Customer" c where "FirstName" = 'Robert';
update "Customer" set "FirstName" = 'Robert', "LastName"  = 'Walter' where "CustomerId"  = 32;
--Task – Update name of artist “Creedence Clearwater Revival” to “CCR”
select * from "Artist" order by "ArtistId";
update "Artist" set "Name" = 'CCR' where "ArtistId" = 76;

--2.5 LIKE
--Task – Select all invoices with a billing address like “T”
select * from "Invoice" i where "BillingAddress" like 'T%';
--2.6 BETWEEN
--Task – Select all invoices that have a total between 15 and 50
select * from "Invoice" i where "Total" between 15 and 50 ;
--Task – Select all employees hired between 1st of June 2003 and 1st of March 2004
select * from "Employee" e where "HireDate" between date '2003-06-01' and date '2004-03-01';
--2.7 DELETE
--Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).
select * from "Customer" c where "FirstName" = 'Robert';

insert into "Customer" values (32, 'Jon', 'Doe', null, '5 Fox Run Rd', 'Raymond', 'NH', 'United States', '03077', '+1(682) 563-3566', null, 'abhilekhadhikari@aol.com', 4);

delete from "Customer" c where "CustomerId" =32; 

--3.0 SQL Functions
--In this section you will be using the PostGreSQL system functions, as well as your own functions, to perform various actions against the database
--
--3.1 System Defined Functions
--Task – Create a query that leverages a system-defined function to return the current time.
select NOW();
--Task – Create a query that leverages a system-defined function to return the length of a mediatype from the mediatype table
--
--3.2 System Defined Aggregate Functions
--Task – Create a query that leverages a system-defined function to return the average total of all invoices
--
--Task – Create a query that leverages a system-defined function to return the most expensive track
--
--3.3 User Defined Scalar Functions
--Task – Create a function that returns the average price of invoice-line items in the invoice-line table
--
--3.4 User Defined Table Valued Functions
--Task – Create a function that returns all employees who are born after 1968.
--
--4.0 JOINS
--In this section you will be working with combining various tables through the use of joins. You will work with outer, inner, right, left, cross, and self joins.
--
--4.1 INNER -- return rows from both tables that match
--Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
select c."LastName" ,c."FirstName" ,i."InvoiceId"  from "Customer" c inner join "Invoice" i on c."CustomerId" = i."CustomerId" ; 
--4.2 OUTER
--Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, last name, invoiceId, and total.
select c."CustomerId" , c."FirstName" , c."LastName" , i."InvoiceId" , i."Total"  from "Customer" c left outer join "Invoice" i on c."CustomerId" = i."CustomerId" ;
--4.3 RIGHT
--Task – Create a right join that joins album and artist specifying artist name and title.
select a."Name" , a2."Title"  from "Artist" a  right outer join "Album" a2  on a."ArtistId" = a2."ArtistId";

--4.4 CROSS
--Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
select * from "Artist" a cross join "Album" a2 order by a."Name" asc;
--4.5 SELF
--Task – Perform a self-join on the employee table, joining on the reports to column.
select * from "Employee" e inner join "Employee" e2 on e."EmployeeId" = e2."ReportsTo" ;