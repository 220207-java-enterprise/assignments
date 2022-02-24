drop table if exists er_reimbursments;
drop table if exists ers_users;
drop table if exists ers_reimbursement_status;
drop table if exists ers_reimbursement_type;
drop table if exists ers_user_roles;


create table er_reimbursments (

	reim_id		varchar,
	amount		 int,
	submitted	timestamp not null,
	resolved	timestamp,
	description varchar not null,
	receipt 	varchar,
	payment_id	varchar not null,
	author_id	varchar not null,
	resolver_id varchar,
	status_id	varchar,
	type_id		varchar,
	primary key (reim_id)	
	
);


-- TODO - work in progress
--alter table er_reimbursments
--add constraint f_K_author_id foreign key (author_id)
--references ers_users (user_id),
--add constraint f_K_resolver_id foreign key (resolver_id)
--references ers_users (user_id);
--
--alter table ers_reimbursement_status
--add constraint f_K_status_id foreign key (staus_id)
--references ers_users (user_id),
--add constraint f_K_resolver_id foreign key (resolver_id)
--references ers_users (user_id);


create table ers_users (

    user_id		varchar,
    user_name	varchar,
    email		varchar,
    password	varchar,
    given_name	varchar,
    surname		varchar,
    is_active	boolean,
    role_id		varchar,
    primary key (user_id)
);


create table ers_reimbursement_status (

	status_id			varchar,
	status				varchar,
	primary key (status_id)


);

create table ers_reimbursement_type (

	type_id				varchar,
	type				varchar,
	
	primary key (type_id)
);

create table ers_user_roles (

    role_id				varchar,
    role				varchar,

    primary key (role_id)
);












