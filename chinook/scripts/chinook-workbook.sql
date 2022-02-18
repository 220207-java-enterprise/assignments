-- SELECT --
select * from "Employee";

select * from "Employee" where "LastName"='King';

select * from "Employee" where "FirstName"='Andrew' 
and "ReportsTo" isnull;

-- ORDER BY --
select * from "Album" order by "Title" desc;

select "FirstName" from "Customer" order by "FirstName" desc;

-- INSERT INTO --
insert into "Genre" values 
	(26, 'Punk Rock'),
	(27, 'Rap');
	
insert into "Employee" values
	(9, 'Amato', 'Aidan', 'Associate Software Developer', 1,'1995-12-20', '2022-02-16', '1234 Place Rd', 'City', 'ST', 'USA', 12345, 1234567890, 0987654321, 'aidan@company.net'),
	(10, 'Musk', 'Elon', 'Creative Department Manager', 9, '1971-06-28', '1971-06-28', '1235 Place Rd', 'City', 'ST', 'USA', 12345, 1324567890, 0897654321, 'elon@company.net');

insert into "Customer" values
	(60, 'Deathsie', 'PekinWoof', null, '12346 Place Dr', 'City', 'ST', 'USA', 12345, 1762948364, null, 'deathsiechan@pekin.org', 4),
	(61, 'Voxy', 'Neace', null, '21347 Place Dr', 'City', 'ST', 'USA', 12345, 9387467291, null, 'voxykun@neace.com', 5);

-- UPDATE --
update "Customer"
set "FirstName"='Robert', "LastName"='Walter'
where "CustomerId"=32;

update "Artist"
set "Name"='Creedence Clearwater Revival'='CCR'
where "Name"='Creedence Clearwater Revival;'

-- LIKE --
select * from "Invoice" where "BillingAddress" like 'T%';

-- BETWEEN --
select * from "Invoice" where "Total" between 15 and 50;

select * from "Employee" where "HireDate" between '2003-6-1' and '2004-3-1';

-- DELETE --
alter table "Invoice"
drop constraint "FK_InvoiceCustomerId";

alter table "Invoice"
add constraint "FK_InvoiceCustomerId"
foreign key ("CustomerId")
references "Customer"("CustomerId")
on delete cascade;

alter table "InvoiceLine"
drop constraint "FK_InvoiceLineInvoiceId";

alter table "InvoiceLine"
add constraint "FK_InvoiceLineInvoiceId"
foreign key ("InvoiceId")
references "Invoice"("InvoiceId")
on delete cascade;

delete from "Customer" where "FirstName"='Robert' and "LastName"='Walter';

-- INNER JOIN --
select concat("Customer"."FirstName", ' ', "Customer"."LastName") as customer_name, "Invoice"."InvoiceId"
from "Customer"
inner join "Invoice"
on "Customer"."CustomerId" = "Invoice"."CustomerId";

-- OUTER JOIN --
select 
	"Customer"."CustomerId", 
	concat("Customer"."FirstName", ' ', "Customer"."LastName") as customer_name, 
	"Invoice"."InvoiceId", "Invoice"."Total"
from "Customer"
full outer join "Invoice"
on "Customer"."CustomerId" = "Invoice"."CustomerId";

-- RIGHT JOIN --
select "Album"."AlbumId", "Artist"."Name"
from "Album"
right join "Artist"
on "Album"."ArtistId" = "Artist"."ArtistId";

-- CROSS JOIN --
select *
from "Album"
cross join "Artist"
order by "Artist"."Name" desc;

-- SELF JOIN --
select 
	concat(A."FirstName", ' ', A."LastName") as employee,
	concat(B."FirstName", ' ', B."LastName") as reports_to
from "Employee" A
join "Employee" B
on A."ReportsTo" = B."EmployeeId";