-- "Foundations".ers_reimbursement_statuses definition

-- Drop table

-- DROP TABLE "Foundations".ers_reimbursement_statuses;

CREATE TABLE "Foundations".ers_reimbursement_statuses (
	status_id varchar NOT NULL,
	status varchar NULL,
	CONSTRAINT ers_reimbursement_statuses_pkey PRIMARY KEY (status_id),
	CONSTRAINT ers_reimbursement_statuses_status_key UNIQUE (status)
);

-- "Foundations".ers_reimbursement_types definition

-- Drop table

-- DROP TABLE "Foundations".ers_reimbursement_types;

CREATE TABLE "Foundations".ers_reimbursement_types (
	type_id varchar NOT NULL,
	"type" varchar NULL,
	CONSTRAINT ers_reimbursement_types_pkey PRIMARY KEY (type_id),
	CONSTRAINT ers_reimbursement_types_type_key UNIQUE (type)
);

-- "Foundations".ers_reimbursements definition

-- Drop table

-- DROP TABLE "Foundations".ers_reimbursements;

CREATE TABLE "Foundations".ers_reimbursements (
	reimb_id varchar NOT NULL,
	amount numeric(6, 2) NOT NULL,
	submitted timestamp NOT NULL,
	resolved timestamp NULL,
	description varchar NOT NULL,
	receipt oid NULL,
	payment_id varchar NULL,
	author_id varchar NOT NULL,
	resolver_id varchar NULL,
	status_id varchar NOT NULL,
	type_id varchar NULL,
	CONSTRAINT ers_reimbursements_pkey PRIMARY KEY (reimb_id)
);

-- "Foundations".ers_user_roles definition

-- Drop table

-- DROP TABLE "Foundations".ers_user_roles;

CREATE TABLE "Foundations".ers_user_roles (
	role_id varchar NOT NULL,
	"role" varchar NULL,
	CONSTRAINT ers_user_roles_pkey PRIMARY KEY (role_id),
	CONSTRAINT ers_user_roles_role_key UNIQUE (role)
);

-- "Foundations".ers_users definition

-- Drop table

-- DROP TABLE "Foundations".ers_users;

CREATE TABLE "Foundations".ers_users (
	user_id varchar NOT NULL,
	username varchar NOT NULL,
	email varchar NOT NULL,
	"password" varchar NOT NULL,
	given_name varchar NOT NULL,
	surname varchar NOT NULL,
	is_active bool NULL,
	role_id varchar NULL,
	CONSTRAINT ers_users_email_key UNIQUE (email),
	CONSTRAINT ers_users_pkey PRIMARY KEY (user_id),
	CONSTRAINT ers_users_username_key UNIQUE (username)
);

INSERT INTO "Foundations".ers_reimbursement_statuses
(status_id, status)
VALUES('', '');

INSERT INTO "Foundations".ers_reimbursement_types
(type_id, "type")
VALUES('', '');

INSERT INTO "Foundations".ers_reimbursements
(reimb_id, amount, submitted, resolved, description, receipt, payment_id, author_id, resolver_id, status_id, type_id)
VALUES('', 0, '', '', '', 0, '', '', '', '', '');

INSERT INTO "Foundations".ers_user_roles
(role_id, "role")
VALUES('', '');

INSERT INTO "Foundations".ers_users
(user_id, username, email, "password", given_name, surname, is_active, role_id)
VALUES('', '', '', '', '', '', false, '');


























-- "Foundations".ers_users foreign keys

ALTER TABLE "Foundations".ers_users ADD CONSTRAINT ers_users_role_id_fkey FOREIGN KEY (role_id) REFERENCES "Foundations".ers_user_roles(role_id);

-- "Foundations".ers_reimbursements foreign keys

ALTER TABLE "Foundations".ers_reimbursements ADD CONSTRAINT ers_reimbursements_author_id_fkey FOREIGN KEY (author_id) REFERENCES "Foundations".ers_users(user_id);
ALTER TABLE "Foundations".ers_reimbursements ADD CONSTRAINT ers_reimbursements_resolver_id_fkey FOREIGN KEY (resolver_id) REFERENCES "Foundations".ers_users(user_id);
ALTER TABLE "Foundations".ers_reimbursements ADD CONSTRAINT ers_reimbursements_status_id_fkey FOREIGN KEY (status_id) REFERENCES "Foundations".ers_reimbursement_statuses(status_id);
ALTER TABLE "Foundations".ers_reimbursements ADD CONSTRAINT ers_reimbursements_type_id_fkey FOREIGN KEY (type_id) REFERENCES "Foundations".ers_reimbursement_types(type_id);


