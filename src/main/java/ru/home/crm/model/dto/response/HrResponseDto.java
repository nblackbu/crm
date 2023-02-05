package ru.home.crm.model.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class HrResponseDto {
    private String firstName;
    private String surName;
    private String role;
}
