create database testdb;
\c testdb
create table if not exists todo (id serial primary key, content text);