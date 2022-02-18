--drop them just in case we need to wipe it all and start over
--while building/setting up the tables
DROP TABLE IF exists ers_reimbursments;
DROP TABLE IF EXISTS ers_users;
DROP TABLE IF EXISTS ers_user_roles;
DROP TABLE IF EXISTS ers_reimbursment_statuses;
DROP TABLE IF EXISTS ers_reimbursment_types;

--start creating tables 
--ers_user_roles
create table ers_user_roles(
	role_id varchar,
	role 	varchar,
	
	constraint ers_user_roles_pk
	primary key (role_id)
);

--ers_users
create table ers_users(
	user_id 	varchar,
	username 	varchar,
	email 		varchar,
	password 	varchar,
	given_name 	varchar,
	surname 	varchar,
	is_active 	boolean,
	role_id 	varchar,
	
	constraint ers_users_pk
	primary key (user_id),
	
	constraint ers_users_role_id_fk
	foreign key (role_id) 
	references  ers_user_roles (role_id)
	
);

--ers_reimbursment_types 
create table ers_reimbursment_types (
	type_id varchar,
	type 	varchar,
	
	constraint reimbursment_types_pk
	primary key (type_id)
);

--ers_reimbursment_statuses 
create table reimbursment_statuses(
	status_id 	varchar,
	status		varchar,
	
	constraint reimbursment_statuses_pk
	primary key (status_id)
);
