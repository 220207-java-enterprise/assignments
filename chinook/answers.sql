--select
--question 1
SELECT * from "Employee";

--question 2
SELECT * from "Employee" where "LastName" like 'King';

--question 3
SELECT * from "Employee" where "FirstName" like 'Andrew' and "ReportsTo" isnull;


--order by
-- question 4
select * from "Album" order by "Title" desc;

-- question 5 
select "FirstName" from "Customer" order by "FirstName" asc;


--insert into
--question 6
insert into "Genre"("GenreId", "Name") values ('26', 'Classic Rock');
insert into "Genre"("GenreId", "Name") values ('27', 'Rap');
select * from "Genre"; -- just to check after adding the two rows

--question 7
insert into "Employee" values
		(9, 'Samolian', 'Bob', 'IT Staff', 6, '1968-02-14', '2010-01-17', '12345 Juniper Street W', 'Newtown', 'WY', 'USA', '83220'),
		(10, 'Joel', 'Billy', 'IT Staff', 6, '1968-12-24', '2000-01-27', '54321 Juniper Street E', 'Newtown', 'WY', 'USA', '83220');
		
--question 8 
insert into "Customer" values
	(60, 'iam', 'yoda', null, '123 my address', 'mycity', 'death', 'notyours', 'ihate', '1234567890', '+12 (12) 1234-1234', 'ihate@gmail.com', '3'),
	(61, 'iwas', 'yoda', null, '312 my address', 'mycity2', 'death3', 'stiltyours', 'istill', '9876543210', '+12 (31) 4321-4311', 'ireally@gmail.com', '4');


--update
--question 9
update "Customer" set "FirstName" = 'Robert', "LastName" = 'Walter' where "FirstName" = 'Aaron' and "LastName" = 'Mitchell';

--question 10
update "Artist" set "Name" = 'CCR' where "Name" = 'Creedence Clearwater Revival';


--like 
--question 11
select * from "Invoice" where "BillingAddress" like 'T%';


--delete
--question 12
--delete from "Invoice" where 
	--"Customer" where "FirstName" = 'Robert' and "LastName" = 'Walter';
alter table "Invoice" drop constraint "FK_InvoiceCustomerId",
	add constraint "FK_InvoiceCustomerId" 
	foreign key ("CustomerId") references "Customer" ("CustomerId") on delete cascade;

alter table "InvoiceLine" drop constraint "FK_InvoiceLineInvoiceId",
	add constraint "FK_InvoiceLineInvoiceId" 
	foreign key ("InvoiceId") references "Invoice" ("InvoiceId") on delete cascade;

delete from "Customer" where "FirstName" = 'Robert' and "LastName" = 'Walter';


--inner
--question 19
select "FirstName", "LastName", "Customer"."CustomerId", "InvoiceId" 
from "Customer" inner join "Invoice" on "Customer"."CustomerId" = "Invoice"."CustomerId";


--outer
--question 20
select concat("FirstName", ' ', "LastName"), "Customer"."CustomerId", "InvoiceId", "Total"
from "Customer" full outer join "Invoice" on "Customer"."CustomerId" = "Invoice"."CustomerId";


--right
--question 21
select "Name", "Title"
from "Artist" right join "Album" on "Artist"."ArtistId" = "Album"."ArtistId";


--cross
--question 22
select "Name", "Title"
from "Artist" cross join "Album" order by "Name" asc;


--self
--question 23
select * from "Employee" e inner join "Employee" m on e."ReportsTo" = m."ReportsTo";