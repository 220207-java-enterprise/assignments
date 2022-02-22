
delete from "Employee" where "EmployeeId" > 8;
delete from "Genre" where "GenreId" > 25;
delete from "Customer" where "CustomerId" > 59;


/*
????????  ?????  ??????? ??   ??     ??????      ??     ??????? ??????? ??      ???????  ?????? ???????? 
   ??    ??   ?? ??      ??  ??           ??    ???     ??      ??      ??      ??      ??         ??    
   ??    ??????? ??????? ?????        ?????      ??     ??????? ?????   ??      ?????   ??         ??    
   ??    ??   ??      ?? ??  ??      ??          ??          ?? ??      ??      ??      ??         ??    
   ??    ??   ?? ??????? ??   ??     ??????? ??  ??     ??????? ??????? ??????? ???????  ??????    ??    
                                                                                                       
*/




SELECT * from "Employee";
select "LastName", "FirstName" from "Employee" where "LastName" = 'King';
select * from "Employee" where "FirstName" = 'Andrew' and  "ReportsTo" is null; 




/*
 ????????  ?????  ??????? ??   ??     ??????     ??????       ??????  ??????  ??????  ??????? ??????      ??????  ??    ?? 
   ??    ??   ?? ??      ??  ??           ??         ??     ??    ?? ??   ?? ??   ?? ??      ??   ??     ??   ??  ??  ??  
   ??    ??????? ??????? ?????        ?????      ?????      ??    ?? ??????  ??   ?? ?????   ??????      ??????    ????   
   ??    ??   ??      ?? ??  ??      ??         ??          ??    ?? ??   ?? ??   ?? ??      ??   ??     ??   ??    ??    
   ??    ??   ?? ??????? ??   ??     ??????? ?? ???????      ??????  ??   ?? ??????  ??????? ??   ??     ??????     ??    
                                                                                                                          
                                                                                                                          
 */




select * from "Album" order by "AlbumId" desc;
select "FirstName" from "Customer" order by "FirstName";




/*
 ????????  ?????  ??????? ??   ??     ??????     ??????      ?? ???    ?? ??????? ??????? ??????  ????????     ?? ???    ?? ????????  ??????  
   ??    ??   ?? ??      ??  ??           ??         ??     ?? ????   ?? ??      ??      ??   ??    ??        ?? ????   ??    ??    ??    ?? 
   ??    ??????? ??????? ?????        ?????      ?????      ?? ?? ??  ?? ??????? ?????   ??????     ??        ?? ?? ??  ??    ??    ??    ?? 
   ??    ??   ??      ?? ??  ??      ??              ??     ?? ??  ?? ??      ?? ??      ??   ??    ??        ?? ??  ?? ??    ??    ??    ?? 
   ??    ??   ?? ??????? ??   ??     ??????? ?? ??????      ?? ??   ???? ??????? ??????? ??   ??    ??        ?? ??   ????    ??     ??????  
                                                                                                                                             
                                                                                                                                             
*/




insert into "Genre" ("GenreId", "Name") values (26, N'Neo-Metal');
insert into "Genre" ("GenreId", "Name") values (27, N'Sapce Rock');

insert into "Employee" 
	("EmployeeId", "LastName", "FirstName", 
	"Title", "ReportsTo", "BirthDate", "HireDate", 
	"Address", "City", "State", "Country", "PostalCode", "Phone", "Fax", "Email") 
	values (9, N'John', N'Abrahim', N'Observer', 1, '1986/12/18', '2022/2/14', N'120 Last Laugh Ave',
	N'Gotham', N'IL', N'United States', N'60666', N'+1 (371) 428-8721', N'+1 (371) 200-7543', N'johna1986@hotmail.com');

insert into "Employee" 
	("EmployeeId", "LastName", "FirstName", "Title", "ReportsTo", "BirthDate", 
	"HireDate", "Address", "City", "State", "Country", "PostalCode", "Phone", "Fax", "Email")
	values (10, N'Rokcy', N'Handsome', N'Entertainer', 1, '1977/11/27', '1999/7/15', N'111 Beauty Ave',
	N'Star City', N'MN', N'United States', N'20211', N'+1 (817) 262-3443', N'+1 (817) 602-5597', N'rhandsome@hotmail.com');

insert into "Customer" 
	("CustomerId", "FirstName", "LastName", "Company", "Address", "City", "State", 
	"Country", "PostalCode", "Phone", "Fax", "Email", "SupportRepId")
	values (60, N'Abhi', N'Shrestha', N'Post Eclipes.', N'2232 Washington Ave', N'Chicago', N'IL', N'USA', N'58223',
	N'+1 (308) 917-1000', N'+1 (308) 971-1001', N'AShre@gmail.com', 3);

insert into "Customer" 
	("CustomerId", "FirstName", "LastName", "Company", "Address", "City", "State", 
	"Country", "PostalCode", "Phone", "Fax", "Email", "SupportRepId") 
	values (61, N'Bruce', N'Wayne', N'Wayne Enterprise', N'Wayne Manor', N'Gotham', N'IL', N'USA', N'55500', 
	N'+1 (971) 622-1953', N'+1 (971) 622-1954', N'batman@gotham.il', 3);




/*
????????  ?????  ??????? ??   ??     ??????     ??   ??     ??    ?? ??????  ??????   ?????  ???????? ??????? 
   ??    ??   ?? ??      ??  ??           ??    ??   ??     ??    ?? ??   ?? ??   ?? ??   ??    ??    ??      
   ??    ??????? ??????? ?????        ?????     ???????     ??    ?? ??????  ??   ?? ???????    ??    ?????   
   ??    ??   ??      ?? ??  ??      ??              ??     ??    ?? ??      ??   ?? ??   ??    ??    ??      
   ??    ??   ?? ??????? ??   ??     ??????? ??      ??      ??????  ??      ??????  ??   ??    ??    ??????? 
   
                                                                                                                                                                                                                         
 */




update "Customer" set "FirstName" = 'Robert', "LastName" = 'Walter' where "CustomerId"  = 32 ;
update "Artist" set "Name" = 'CCR' where "ArtistId" = 76;

select * from "Genre";
select * from "Employee";
select * from "Customer";




/*
????????  ?????  ??????? ??   ??     ??????     ???????     ??      ?? ??   ?? ??????? 
   ??    ??   ?? ??      ??  ??           ??    ??          ??      ?? ??  ??  ??      
   ??    ??????? ??????? ?????        ?????     ???????     ??      ?? ?????   ?????   
   ??    ??   ??      ?? ??  ??      ??              ??     ??      ?? ??  ??  ??      
   ??    ??   ?? ??????? ??   ??     ??????? ?? ???????     ??????? ?? ??   ?? ??????? 
                                                                                       
                                                                                                                                                                          
*/




select * from "Invoice" where "BillingAddress" like 'T%';




/*
????????  ?????  ??????? ??   ??     ??????      ??????      ??????  ??????? ???????? ??     ?? ??????? ??????? ???    ?? 
   ??    ??   ?? ??      ??  ??           ??    ??           ??   ?? ??         ??    ??     ?? ??      ??      ????   ?? 
   ??    ??????? ??????? ?????        ?????     ???????      ??????  ?????      ??    ??  ?  ?? ?????   ?????   ?? ??  ?? 
   ??    ??   ??      ?? ??  ??      ??         ??    ??     ??   ?? ??         ??    ?? ??? ?? ??      ??      ??  ?? ?? 
   ??    ??   ?? ??????? ??   ??     ??????? ??  ??????      ??????  ???????    ??     ??? ???  ??????? ??????? ??   ???? 
                                                                                                                          
*/                                                                                                                        




select * from "Invoice" where "Total" between 15 and 50;

select * from "Employee" where "HireDate" between '2003/06/01' and '2004/03/01';




/*
 ????????  ?????  ??????? ??   ??     ??????     ???????     ??????  ??????? ??      ??????? ???????? ??????? 
   ??    ??   ?? ??      ??  ??           ??         ??     ??   ?? ??      ??      ??         ??    ??      
   ??    ??????? ??????? ?????        ?????         ??      ??   ?? ?????   ??      ?????      ??    ?????   
   ??    ??   ??      ?? ??  ??      ??            ??       ??   ?? ??      ??      ??         ??    ??      
   ??    ??   ?? ??????? ??   ??     ??????? ??    ??       ??????  ??????? ??????? ???????    ??    ??????? 
                                                                                                             
                                                                                                           
 */
 


alter table "Invoice"
drop constraint "FK_InvoiceCustomerId";

alter table "Invoice"
add constraint "FK_InvoiceCustomerId";
foreign key ("CustomerId")
references "Customer"("CustomerId")
on delete cascade;

delete from "Customer"
where "FirstName" = 'Robert' and "LastName" = 'Walter';

--delete from "InvoiceLine" where "InvoiceId"  = 50 and "InvoiceLineId" = 61;
--delete from "Invoice" where "CustomerId" = 32;
--delete from "Customer" where "FirstName" = 'Robert' and "LastName" = 'Walter' and "CustomerId" = 32;

 
 
 
/*
????????  ?????  ??????? ??   ??     ??????      ??     ???????  ??????  ??          ??????? ??    ?? ???    ??  ?????? ???????? ??  ??????  ???    ?? ??????? 
   ??    ??   ?? ??      ??  ??           ??    ???     ??      ??    ?? ??          ??      ??    ?? ????   ?? ??         ??    ?? ??    ?? ????   ?? ??      
   ??    ??????? ??????? ?????        ?????      ??     ??????? ??    ?? ??          ?????   ??    ?? ?? ??  ?? ??         ??    ?? ??    ?? ?? ??  ?? ??????? 
   ??    ??   ??      ?? ??  ??           ??     ??          ?? ?? ?? ?? ??          ??      ??    ?? ??  ?? ?? ??         ??    ?? ??    ?? ??  ?? ??      ?? 
   ??    ??   ?? ??????? ??   ??     ??????  ??  ??     ???????  ??????  ???????     ??       ??????  ??   ????  ??????    ??    ??  ??????  ??   ???? ??????? 
                                                                    ??                                                                                         
                                                                                                                                                             
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
 */

 
 
 
select current_time;
select timeofday();


select cast(avg("Total")as decimal(6,2)) from "Invoice";
select max("UnitPrice") from "Track";




/*
 ????????  ?????  ??????? ??   ??     ??   ??     ??     ?? ???    ?? ???    ?? ??????? ??????  
   ??    ??   ?? ??      ??  ??      ??   ??    ???     ?? ????   ?? ????   ?? ??      ??   ?? 
   ??    ??????? ??????? ?????       ???????     ??     ?? ?? ??  ?? ?? ??  ?? ?????   ??????  
   ??    ??   ??      ?? ??  ??           ??     ??     ?? ??  ?? ?? ??  ?? ?? ??      ??   ?? 
   ??    ??   ?? ??????? ??   ??          ?? ??  ??     ?? ??   ???? ??   ???? ??????? ??   ?? 
                                                                                               
                                                                                               
 */




select "Invoice"."InvoiceId", "Customer"."FirstName", "Customer"."LastName"
from "Customer" inner join "Invoice" 
on "Customer"."CustomerId" = "Invoice"."CustomerId"; 




/*
 ????????  ?????  ??????? ??   ??     ??   ??    ??????      ??????? ??    ?? ??      ??           ??????  ??    ?? ???????? ??????? ??????  
   ??    ??   ?? ??      ??  ??      ??   ??         ??     ??      ??    ?? ??      ??          ??    ?? ??    ??    ??    ??      ??   ?? 
   ??    ??????? ??????? ?????       ???????     ?????      ?????   ??    ?? ??      ??          ??    ?? ??    ??    ??    ?????   ??????  
   ??    ??   ??      ?? ??  ??           ??    ??          ??      ??    ?? ??      ??          ??    ?? ??    ??    ??    ??      ??   ?? 
   ??    ??   ?? ??????? ??   ??          ?? ?? ???????     ??       ??????  ??????? ???????      ??????   ??????     ??    ??????? ??   ?? 
                                                                                                                                            
 */




select "Customer"."CustomerId", "Invoice"."InvoiceId", "Customer"."FirstName" , "Customer"."LastName", "Invoice"."Total" 
from "Invoice" full outer join "Customer" on  "Customer"."CustomerId" = "Invoice"."InvoiceId"; 




/*
  ????????  ?????  ??????? ??   ??     ??   ??    ??????      ??????  ??  ??????  ??   ?? ????????          ??  ??????  ?? ???    ?? 
   ??    ??   ?? ??      ??  ??      ??   ??         ??     ??   ?? ?? ??       ??   ??    ??             ?? ??    ?? ?? ????   ?? 
   ??    ??????? ??????? ?????       ???????     ?????      ??????  ?? ??   ??? ???????    ??             ?? ??    ?? ?? ?? ??  ?? 
   ??    ??   ??      ?? ??  ??           ??         ??     ??   ?? ?? ??    ?? ??   ??    ??        ??   ?? ??    ?? ?? ??  ?? ?? 
   ??    ??   ?? ??????? ??   ??          ?? ?? ??????      ??   ?? ??  ??????  ??   ??    ??         ?????   ??????  ?? ??   ???? 
                                                                                                                                   
                                                                                                                                   
*/




select "Artist"."Name", "Album"."Title" from "Artist" right join
"Album" on "Album"."ArtistId" = "Artist"."ArtistId";



/*
 ????????  ?????  ??????? ??   ??     ??   ??    ??   ??      ?????? ??????   ??????  ??????? ???????          ??  ??????  ?? ???    ?? 
   ??    ??   ?? ??      ??  ??      ??   ??    ??   ??     ??      ??   ?? ??    ?? ??      ??               ?? ??    ?? ?? ????   ?? 
   ??    ??????? ??????? ?????       ???????    ???????     ??      ??????  ??    ?? ??????? ???????          ?? ??    ?? ?? ?? ??  ?? 
   ??    ??   ??      ?? ??  ??           ??         ??     ??      ??   ?? ??    ??      ??      ??     ??   ?? ??    ?? ?? ??  ?? ?? 
   ??    ??   ?? ??????? ??   ??          ?? ??      ??      ?????? ??   ??  ??????  ??????? ???????      ?????   ??????  ?? ??   ???? 
                                                                                                                                       
                                                                                                                                       
 */




select * from "Artist"
cross join "Album" order by "Name";



/*
 ????????  ?????  ??????? ??   ??     ??   ??    ???????     ??????? ??????? ??      ???????          ??  ??????  ?? ???    ?? 
   ??    ??   ?? ??      ??  ??      ??   ??    ??          ??      ??      ??      ??               ?? ??    ?? ?? ????   ?? 
   ??    ??????? ??????? ?????       ???????    ???????     ??????? ?????   ??      ?????            ?? ??    ?? ?? ?? ??  ?? 
   ??    ??   ??      ?? ??  ??           ??         ??          ?? ??      ??      ??          ??   ?? ??    ?? ?? ??  ?? ?? 
   ??    ??   ?? ??????? ??   ??          ?? ?? ???????     ??????? ??????? ??????? ??           ?????   ??????  ?? ??   ???? 
                                                                                                                              
                                                                                                                             
 */




select * from "Employee" e join "Employee" e1 on  e."EmployeeId" e1."ReportsTo";





