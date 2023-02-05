package ru.home.crm.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.home.crm.exception.HrNotFoundException;
import ru.home.crm.model.HrModel;
import ru.home.crm.model.dto.request.HrRequestDto;
import ru.home.crm.model.dto.response.HrResponseDto;
import ru.home.crm.repos.HrRepo;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HrServiceImpl implements HrService {


    private final HrRepo hrRepo;
    @Autowired
    private final ModelMapper modelMapper;


    @Override
    public HrResponseDto findByID(Long id) {

        HrModel hrModel = hrRepo.findById(id).orElseThrow(() -> new HrNotFoundException());
        return modelMapper.map(hrModel, HrResponseDto.class);
    }

    public List<HrResponseDto> allHr() {
        List<HrModel> hrs = hrRepo.findAll();
        return hrRepo.findAll().stream().map(this::convertToHr).
                collect(Collectors.toList());
    }

    public HrResponseDto convertToHr(HrModel hrModel) {
        return modelMapper.map(hrModel, HrResponseDto.class);
    }

    public void delete(Long id) {
        hrRepo.deleteById(id);
    }

    public HrResponseDto update(HrRequestDto hrRequestDto) {
        return modelMapper.map(hrRepo.save(modelMapper.map(hrRequestDto, HrModel.class)), HrResponseDto.class);
    }
    @Transactional
    public void save(HrRequestDto hrRequestDto) {
        hrRepo.save(modelMapper.map(hrRequestDto, HrModel.class));
    }

}
