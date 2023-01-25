package ru.home.crm.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.home.crm.mapper.Mapper;
import ru.home.crm.model.HrModel;
import ru.home.crm.model.dto.response.HrResponseDto;
import ru.home.crm.repos.HrRepo;

@Service
@RequiredArgsConstructor
public class HrServiceImpl implements HrService {

    private final HrRepo hrRepo;
    private final Mapper mapper;

    @Override
    public HrResponseDto findByID(Long id) {
        HrModel hrModel = hrRepo.findById(id).orElseThrow(() -> new RuntimeException());

        return mapper.toResponse(hrModel);
    }


}
