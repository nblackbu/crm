package ru.home.crm.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
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
@Table(name = "hr")
public class HrModel {

    @Id
    @Column(name = "hr_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "role", referencedColumnName = "role")
    private String role;

    @Column(name = "firstname")
    @NotEmpty(message = "Поле Имя не может быть пустым")
    @Size(min = 2, max = 30, message = "Имя должно иметь от 2-х до 30-ти символов")
    private String firstName;

    @Column(name = "surname")
    @NotEmpty(message = "Поле Фамилия не может быть пустым")
    @Size(min = 2, max = 30, message = "Фамилия должно иметь от 2-х до 30-ти символов")
    private String surName;

    @Column(name = "login")
    @NotEmpty(message = "Поле Логин не может быть пустым")
    @Size(min = 2, max = 30, message = "Логин должен иметь от 2-х до 30-ти символов")
    private String login;

    @Column(name = "password")
    @NotEmpty(message = "Поле Пароль не может быть пустым")
    @Size(min = 2, max = 30, message = "Пароль должен иметь от 2-х до 30-ти символов")
    private String password;

}
