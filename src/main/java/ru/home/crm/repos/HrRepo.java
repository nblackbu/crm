package ru.home.crm.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.home.crm.model.HrModel;

//JpaRepository - это класс, который в себе хранит методы JDBC. Оборачивает в методы Hibernate
@Repository
public interface HrRepo extends JpaRepository<HrModel, Long> {

}
