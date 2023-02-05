insert into roles (role)
values
    ('USER'),
    ('ADMIN');

insert into status (status)
values
    ('CLOSE'),
    ('NEW');

insert into candidate_status (status)
values
    ('NEW'),
    ('OFFER'),
    ('DENIED');

insert into candidate (hr_id,vacancies_id,status,firstname,surname,age)
values
    (1),
    (1),
    ('NEW'),
    ('Bob'),
    ('Maxwell'),
    (29);

insert into hr (firstname,surname,login,password,role)
values
    ('Lana'),
    ('Davis '),
    ('LanaDavis'),
    ('123'),
    ('Maxwell'),
    ('ADMIN');

insert into hr_to_vacanies (hr_id, vacancies_id)
values
    (1),
    (1);

insert into vacanies_status (status)
values
    ('ACTIVE'),
    ('DEACTIVE');