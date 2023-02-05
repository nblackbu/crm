create table hr(
    hr_id bigserial primary key,
    firstname varchar(256) not null,
    surname varchar(256) not null,
    login varchar(256) not null unique,
    password varchar(256) not null,
    role varchar(64) not null,
    creation_date timestamp default current_timestamp,
    foreign key (role) references roles(role)
);