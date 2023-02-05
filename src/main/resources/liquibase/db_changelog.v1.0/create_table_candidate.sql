create table candidate(
    candidate_id bigserial primary key,
    hr_id bigint default '1',
    vacancies_id bigint not null,
    status varchar(64) default 'NEW',
    creation_date timestamp default current_timestamp,
    firstname varchar(256) not null,
    surname varchar(256) not null,
    age int CHECK(age > 18),
    foreign key (hr_id) references hr(hr_id),
    foreign key (vacancies_id) references vacancies(vacancies_id)
);