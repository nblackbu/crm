package ru.home.crm.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@Getter
@AllArgsConstructor
@Setter
@Entity
//@Table() - name таблиц hr
public class HrModel {
    private Long id;
}
