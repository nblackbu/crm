package ru.home.crm.exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class HrErrorResponse {
    private String message;
    private long timestamp;
}
