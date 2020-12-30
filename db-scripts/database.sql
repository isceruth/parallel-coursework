create database server;

create table server_actions(
    action_id serial PRIMARY KEY,
    user_uuid uuid,
    firstname varchar(50),
    lastname varchar(50),
    time timestamp,
    action varchar(50)
)