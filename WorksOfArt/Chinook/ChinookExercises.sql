select * from "Employee";

select * from "Employee" where "LastName" = 'King';

select * from "Employee" where "FirstName"= 'Andrew' and "ReportsTo"  is null;

--select * from "Employee" where  "ReportsTo"  is null;

select * from "Album" order by "Title" asc ;

select "FirstName" from "Customer" order by "FirstName" asc ;

select * from "Genre" order by "GenreId" desc 

insert into "Genre" 
values (26, 'Country'),
	(27, 'Gospel');
	
--select * from "Employee" ;

insert into "Employee" values 
	(9, 'Davidson', 'Arthur', 'IT Staff', 6, '1961-01-26', '2022-01-07', '123 W. Easy Street', 'Chatsworth', 'CA', 'USA;', '91311', '(661) 310-6725)', null, 'arthur026@revature.net'),
	(10, 'Davidson', 'Richard', 'IT Staff', 6, '1959-03-27', '2022-01-07', '123 W. Easy Street', 'Chatsworth', 'CA', 'USA;', '91311', '(661) 555-6725)', null, 'someone@rsomewhere.com')
	
--select * from "Customer" c order by "CustomerId" desc ;

insert into "Customer" values 
	(60, 'Scooby', 'Doo', 'Hanna Barbera', '123 Main Street', 'Disneyland', 'CA[', 'USA', '92803', null, null, 'scooby.doo@revature.net'),
	(61, 'Shaggy', 'Rogers', 'Revature', '123 Easy Street', 'Disneyland', 'CA', 'USA', '92803', NULL, NULL, 'shaggy.rogers@revature.net')

update "Customer" set "FirstName" = 'Robert', "LastName" = 'Walter'
	where "FirstName" = 'Aaron' and "LastName" = 'Mitchell';
	
update "Artist" set "Name" = 'CCR' where "Name" = 'Creedence Clearwater Revival';

select * from "Invoice" i  where "BillingAddress" like 'T%';

select * from "Invoice" i where "Total" between 15 and 50;

--select * from "Employee" 
select * from "Employee" e where "HireDate" between '2003-06-01' and '2004-03-01';

delete from "Customer" where "FirstName"  = 'Robert' and "LastName" = 'Walter';

-- doesn't work
alter table "Invoice" 
add constraint FK_InvoiceCustomerId
references Customer(CustomerId)
on delete cascade;

select current_time ;

select "Name", length("Name") as Length from "MediaType" mt ;

select avg("Total") from "Invoice" i 

select "TrackId", "Name", "Composer", "UnitPrice"  from "Track" t 
where "UnitPrice" = (select max("UnitPrice")   from "Track");
having "UnitPrice"  = max("UnitPrice");

select max("UnitPrice") from "Track" t 

select  c."FirstName" , c."LastName" , i."InvoiceId" 
from "Customer" c inner join "Invoice" i 
on i."CustomerId" = c."CustomerId" 
order by c."LastName" , c."FirstName" ;

select c."FirstName" , c."LastName" , i."CustomerId" , count(i."InvoiceId") as "orders"
from "Customer" c left outer join "Invoice" i 
on i."CustomerId" =c."CustomerId" 
group by c."LastName" , c."FirstName" , i."CustomerId" 
order by c."LastName" , c."FirstName", i."CustomerId" 

select max("CustomerId") from "Customer" c ;

update "Customer" set "CustomerId" = 63 where "FirstName" ='Scooby' and "LastName" = 'Doo';
commit

select c."CustomerId" , c."FirstName" , c."LastName" , i."InvoiceId" , i."Total" 
from "Customer" c left outer join "Invoice" i 
on i."CustomerId" = c."CustomerId" 
order by c."LastName" , c."FirstName" 

select a."Title" , a2."Name" 
from "Album" a right outer join "Artist" a2 
on a."ArtistId" = a2."ArtistId" 
order by a2."Name" ;

select a."Title" , a2."Name" 
from "Album" a cross join "Artist" a2 
order by a2."Name" , a."Title" 


select e."EmployeeId" as BossID, e."LastName" , e."FirstName" , e2."EmployeeId" , e2."LastName" as ELName, e2."FirstName" asEFName
from "Employee" e left outer join "Employee" e2
on e2."ReportsTo" = e."EmployeeId" 
order by e."LastName" , e."FirstName" , e2."LastName" , e2."FirstName" 