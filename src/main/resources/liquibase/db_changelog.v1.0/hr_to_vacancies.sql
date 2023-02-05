create table hr_to_vacancies(
      hr_id bigint not null,
      vacancies_id bigint not null,
      primary key (hr_id, vacancies_id),
      foreign key (hr_id) references hr(hr_id),
      foreign key (vacancies_id) references vacancies(vacancies_id),
);