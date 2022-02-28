--Create table ers_user_roles
CREATE TABLE ers_user_roles(
    role_id             VARCHAR primary key,--pk
    role                VARCHAR unique
);

--Create table ers_users
CREATE TABLE ers_users(
    user_id             VARCHAR primary key,--pk
    username            VARCHAR unique NOT NULL,
    email               VARCHAR unique NOT NULL,
    password            VARCHAR NOT NULL,
    given_name          VARCHAR NOT NULL,
    surname             VARCHAR NOT NULL,
    is_active           BOOLEAN,
    role_id             VARCHAR
);
--Add foreign key to role_id in ers_users referencing ers_user_roles
ALTER TABLE ers_user_roles
ADD foreign key (role_id)
REFERENCES ers_user_roles(role_id);

--Create table ers_reimbursements
CREATE TABLE ers_reimbursements(
    reimb_id            VARCHAR primary key,--pk
    amount              NUMERIC(6,2) NOT NULL,
    submitted           TIMESTAMP NOT NULL,
    resolved            TIMESTAMP,
    description         VARCHAR NOT NULL,
    receipt             BYTEA,--TODO: 'BLOB' syntax? Could be BYTEA
    payment_id          VARCHAR,
    author_id           VARCHAR NOT NULL,--fk
    resolver_id         VARCHAR,--fk
    status_id           VARCHAR NOT NULL,--fk
    type_id             VARCHAR NOT NULL--fk
 );
 --Alter table ers_reimbursements to add fk to author_id
 ALTER TABLE ers_reimbursements
 ADD foreign key (author_id)
 REFERENCES ers_users(user_id);
--Alter table ers_reimbursements to add fk to resolver_id
 ALTER TABLE ers_reimbursements
 ADD foreign key (resolver_id)
 REFERENCES ers_users(user_id);

--Create table ers_reimbursement_statuses
CREATE TABLE ers_reimbursement_statuses(
    status_id           VARCHAR primary key,--pk
    status              VARCHAR unique
);

--Alter table ers-reimbursements to add fk to status_id referencing ers_reimbursement_statuses
 ALTER TABLE ers_reimbursements
 ADD foreign key (status_id)
 REFERENCES ers_reimbursement_statuses(status_id);

 --Create table ers_reimbursement_types
 CREATE TABLE ers_reimbursement_types(
    type_id             VARCHAR primary key,--pk
    type                VARCHAR unique
 );

 --Alter table ers_reimbursements to add fk to type_id referencing ers_reimbursement_types
 ALTER TABLE ers_reimbursements
 ADD foreign key (type_id)
 REFERENCES ers_reimbursement_types(type_id);

--/*Sanity check
--select * from ers_user_roles;
--select * from ers_users;
--select * from ers_reimbursements;
--select * from ers_reimbursement_statuses;
--select * from ers_reimbursement_types;
--*/
