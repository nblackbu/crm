package ru.home.crm.service;

import ru.home.crm.model.dto.response.HrResponseDto;

public interface HrService {
    HrResponseDto findByID(Long id);
}
