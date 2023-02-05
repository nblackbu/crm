package ru.home.crm.model.dto.request;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class HrRequestDto {

    private String role;

    @NotEmpty(message = "Поле Имя не может быть пустым")
    @Size(min = 2, max = 30, message = "Имя должно иметь от 2-х до 30-ти символов")
    private String firstName;

    @NotEmpty(message = "Поле Фамилия не может быть пустым")
    @Size(min = 2, max = 30, message = "Фамилия должно иметь от 2-х до 30-ти символов")
    private String surName;

    @NotEmpty(message = "Поле Логин не может быть пустым")
    @Size(min = 2, max = 30, message = "Логин должен иметь от 2-х до 30-ти символов")
    private String login;

    @NotEmpty(message = "Поле Пароль не может быть пустым")
    @Size(min = 2, max = 30, message = "Пароль должен иметь от 2-х до 30-ти символов")
    private String password;
}
