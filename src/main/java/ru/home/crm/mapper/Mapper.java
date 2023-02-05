package ru.home.crm.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.home.crm.model.HrModel;
import ru.home.crm.model.dto.request.HrRequestDto;
import ru.home.crm.model.dto.response.HrResponseDto;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class Mapper {

//    public List<HrModel> toResponseFindAll(List<HrModel> hrModel) {
//        List<HrResponseDto> hrResponseDtos = new ArrayList<>();
//
//        for (HrModel hr : hrModel) {
//            hrResponseDtos.setId(hr.getId());
//            hrResponseDtos.setSurname(hr.getSurName());
//            hrResponseDtos.setFirstname(hr.getFirstName());
//        }
//    }

}
