package ru.home.crm.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.home.crm.model.HrModel;
import ru.home.crm.model.dto.request.HrRequestDto;
import ru.home.crm.model.dto.request.HrUpdateRequestDto;
import ru.home.crm.model.dto.response.HrResponseDto;

@Component
@RequiredArgsConstructor
public class HrMapper {
    private final ObjectMapper objectMapper;
    public HrResponseDto toResponse(HrModel hrModel) {
        return objectMapper.convertValue(hrModel, HrResponseDto.class);
    }

    public HrModel toModel(HrRequestDto hrRequestDto) {
        return objectMapper.convertValue(hrRequestDto, HrModel.class);

    }

    public HrModel fromRequestUpdate(HrUpdateRequestDto hrUpdateRequestDto) {
        return objectMapper.convertValue(hrUpdateRequestDto, HrModel.class);
    }

    //берет поля source target  если они равны, оставляем как есть, если нет то в поля target пишем source
    public HrModel toUpdateModel(HrModel hrModelSource, HrModel hrModelTarget) {
        // перевести tsource в таргет и вернуть таргет
        return hrModelTarget;
    }
}
