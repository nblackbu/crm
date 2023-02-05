package ru.home.crm.model;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@AllArgsConstructor
@Setter
@Entity
@Table(name = "candidate")
public class CandidateModel {

    @Id
    @Column(name = "candidate_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "firstname")
    @NotEmpty
    private String firstName;

    @Column(name = "surname")
    @NotEmpty
    private String surName;

    @Column(name = "age")
    @NotEmpty
    @Min(value = 0, message = "Возраст кандидата не может быть менее 18")
    private int age;
}
