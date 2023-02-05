package ru.home.crm.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.home.crm.model.HrModel;

@Repository
public interface VacanciesRepo extends JpaRepository<HrModel, Long> {

}
