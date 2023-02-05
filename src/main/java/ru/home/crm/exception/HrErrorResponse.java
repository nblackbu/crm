package ru.home.crm.exception;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
public class HrErrorResponse {
    private String message;
    private long timestamp;
}
