create database dts;

use dts;

create table user (id bigint AUTO_INCREMENT, first_name varchar(50), last_name varchar(50), username varchar(50), 
password varchar(50), qualificaiton varchar(50), designation varchar(50), 
address varchar(500), email_address varchar(100), contact_number varchar(15), PRIMARY KEY (id));

create table softwares (id bigint AUTO_INCREMENT, soft_name varchar(50), 
soft_desc varchar(50), modified_date time, primary key(id));

create table modules (id bigint AUTO_INCREMENT, module_name varchar(50), 
description varchar(50), fk_id bigint ,modified_date time, primary key(id));

