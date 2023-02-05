package ru.home.crm.repos;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.home.crm.model.HrModel;

import java.util.Optional;

//JpaRepository - это класс, который в себе хранит методы JDBC. Оборачивает в методы Hibernate
@Repository
public interface HrRepo extends JpaRepository<HrModel, Long> {
    Optional<HrModel> findByLogin(String login);
    Page<HrModel> findAll(Pageable pageable);
}
