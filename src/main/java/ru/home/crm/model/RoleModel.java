package ru.home.crm.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@NoArgsConstructor
@Getter
@AllArgsConstructor
@Setter
@Entity
@Table(name = "roles")
public class RoleModel {
    @OneToMany(mappedBy = "role")
    private String role;
}
