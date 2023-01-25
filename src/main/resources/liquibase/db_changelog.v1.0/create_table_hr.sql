create table hr(
    id bigserial primary key,
    firstname varchar(256) not null,
    surname varchar(256) not null,
    login varchar(256) not null unique,
    password varchar(256) not null
)