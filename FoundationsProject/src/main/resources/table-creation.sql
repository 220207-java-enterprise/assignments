drop table if exists ERS_REIMBURSEMENTS;
drop table if exists ERS_USERS;
drop table if exists ERS_USER_ROLES;
drop table if exists ERS_REIMBURSEMENT_TYPES;
drop table if exists ERS_REIMBURSEMENT_STATUSES;

create table ERS_REIMBURSEMENT_STATUSES(
	STATUS_ID		VARCHAR primary key,
	STATUS			VARCHAR unique
);

create table ERS_REIMBURSEMENT_TYPES(
	TYPE_ID			VARCHAR primary key,
	TYPE			VARCHAR unique
);

create table ERS_USER_ROLES(
	ROLE_ID			VARCHAR primary key,
	ROLE			VARCHAR unique
);

create table ERS_USERS(
	USER_ID			VARCHAR primary key,
	USERNAME		VARCHAR unique not null,
	EMAIL			VARCHAR unique not null,
	PASSWORD		VARCHAR not null,
	GIVEN_NAME		VARCHAR not null,
	SURNAME			VARCHAR not null,
	IS_ACTIVE		BOOLEAN,
	ROLE_ID			VARCHAR
);

create table ERS_REIMBURSEMENTS(
	REIMB_ID		VARCHAR primary key,
	AMOUNT			DECIMAL(6,2) not null,
	SUBMITTED 		TIMESTAMP,
	RESOLVED		TIMESTAMP,
	DESCRIPTION		VARCHAR not null,
	RECEIPT			BYTEA,
	PAYMENT_ID		VARCHAR,
	AUTHOR_ID		VARCHAR not null,
	RESOLVER_ID		VARCHAR,
	STATUS_ID		VARCHAR not null,
	TYPE_ID			VARCHAR not null
	);

alter table ERS_USERS
add foreign key (ROLE_ID)
references ERS_USER_ROLES(ROLE_ID);

alter table ERS_REIMBURSEMENTS
add foreign key (AUTHOR_ID)
references ERS_USERS(USER_ID);

alter table ERS_REIMBURSEMENTS
add foreign key (STATUS_ID)
references ERS_REIMBURSEMENT_STATUSES(STATUS_ID);

alter table ERS_REIMBURSEMENTS
add foreign key (TYPE_ID)
references ERS_REIMBURSEMENT_TYPES(TYPE_ID);