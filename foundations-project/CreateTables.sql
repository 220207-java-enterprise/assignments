create table ers_user_roles (
	ROLE_ID	varchar	primary key,
	role	varchar unique
)

create table ers_reimbursement_types (
	type_id	varchar primary key,
	type	varchar unique 
)

create table ers_reimbursement_statuses (
	status_id	varchar primary key,
	status		varchar unique 
)

create table ers_users (
	user_id		varchar	primary key,
	username	varchar not null unique,
	email		varchar not null unique,
	password	varchar not null,
	given_name	varchar not null,
	surname		varchar not null,
	is_active	boolean,
	role_id varchar,
	foreign key (role_id) references ers_user_roles(role_id)
)

create table ers_reimbursements (
	reimb_id	varchar primary key,
	amount		numeric(6, 2) not null,
	submitted	timestamp not null,
	resolved	timestamp,
	description varchar not null,
	receipt		oid,
	payment_id	varchar,
	author_id	varchar not null,
	resolver_id	varchar,
	status_id	varchar not null,
	type_id		varchar,
	foreign key (author_ID) references ers_users(user_id),
	foreign key (resolver_id) references ers_users(user_id),
	foreign key (status_id) references ers_reimbursement_statuses(status_id),
	foreign key (type_id) references ers_reimbursement_types 
)









