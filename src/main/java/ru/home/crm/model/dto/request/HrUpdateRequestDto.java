package ru.home.crm.model.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class HrUpdateRequestDto {
    String firstname;
    String lastname;
    String login;
}
