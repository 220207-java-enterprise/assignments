DROP TABLE IF EXISTS APP_USERS;
go;
drop table if exists user_roles
GO;
drop table if exists Categories
GO;
drop table if exists study_set_cards
GO


CREATE TABLE USER_ROLES (

	id	varchar	PRIMARY KEY,
	role_name varchar NOT null

)


CREATE TABLE APP_USERS (
	id varchar PRIMARY KEY,
	first_name varchar NOT NULL,
	last_name varchar NOT NULL,
	email varchar(256) NOT null unique,
	username varchar(25) UNIQUE NOT NULL,
	password varchar NOT NULL,
	ROLE varchar ,
	foreign key (role) references user_roles (id)

)


create table Categories (
	id varchar primary key,
	category_name varchar not null 
)

create table STUDY_SET_CARDS (
	study_set_id	varchar,
	flashcard_id	varchar,
	constraint primary_key(study_set_id, lfashcard_id)

)

create table study_sets (
	id		varchar	primary key,
	name	varchar not null,
	owner_id varchar not null,
	
	category varchar not null, 
	foreign key (category) references categories(id),
	foreign key (owner_id) references app_users(id)
)

create table flashcards (
	id		varchar primary key,
	question_text varchar not null,
	answer_text varchar not null,
	category varchar not null,
	creator_id varchar not null,
	foreign key (creator_id) references app_users(id),
	foreign key (category)  references categories(id)



)