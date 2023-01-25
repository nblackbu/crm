package ru.home.crm.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.home.crm.model.HrModel;
import ru.home.crm.model.dto.response.HrResponseDto;

@Component
@RequiredArgsConstructor
public class Mapper {
    // берет модель и превращает в дто
    public HrResponseDto toResponse(HrModel hrModel) {
        HrResponseDto hrResponseDto = new HrResponseDto();
        hrResponseDto.setId(hrModel.getId());

        return hrResponseDto;
    }

}
