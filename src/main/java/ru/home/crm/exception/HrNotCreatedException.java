package ru.home.crm.exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class HrNotCreatedException extends RuntimeException {
    public HrNotCreatedException(String msg) {
        super(msg);
    }
}
