create table vacancies(
    vacansies_id bigserial primary key,
    title varchar(256) not null,
    creation_date timestamp default current_timestamp,
    status varchar(64) default 'NEW',
    foreign key (status) references vacancies_status(status)
);