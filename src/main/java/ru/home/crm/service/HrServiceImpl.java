package ru.home.crm.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.home.crm.exception.NoSuchUserException;
import ru.home.crm.mapper.HrMapper;
import ru.home.crm.model.HrModel;
import ru.home.crm.model.dto.request.HrRequestDto;
import ru.home.crm.model.dto.request.HrUpdateRequestDto;
import ru.home.crm.model.dto.response.HrResponseDto;
import ru.home.crm.repos.HrRepo;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class HrServiceImpl implements HrService {


    private final HrRepo hrRepo;
    private final HrMapper hrMapper;


    @Override
    public HrResponseDto findByID(Long id) {

        HrModel hrModel = hrRepo.findById(id).orElseThrow(() -> new NoSuchUserException("Пользователь не найден"));
        HrResponseDto hrResponseDto = hrMapper.toResponse(hrModel);
        return hrResponseDto;
    }

    public Page<HrResponseDto> findAll(Pageable pageable) {
        Page<HrResponseDto> hrResponseDtos = hrRepo.findAll(pageable).map(hrMapper::toResponse);
        return hrResponseDtos;
    }

    @Transactional
    public void delete(Long id) {
        hrRepo.deleteById(id);
    }


    @Transactional
    public HrResponseDto update(Long id, HrUpdateRequestDto hrUpdateRequestDto) {
        log.info("Обновление hr");
        HrModel source = hrMapper.fromRequestUpdate(hrUpdateRequestDto);
        HrModel target = hrRepo.findById(id).orElseThrow(()-> new NoSuchUserException("Пользователь не был найден"));
        if (!source.getLogin().equals(target.getLogin())) {
            if (hrRepo.findByLogin(source.getLogin()).isPresent())
                throw new RuntimeException("Пользователь с таким логином уже существует");
        }
        HrModel updateModel = hrMapper.toUpdateModel(source, target);
        HrResponseDto updateResponse = hrMapper.toResponse(hrRepo.save(updateModel));
        log.info("Обновление завершено");
        return updateResponse;
    }
    @Transactional
    public HrResponseDto create(HrRequestDto hrRequestDto) {
        HrModel hrModel = hrMapper.toModel(hrRequestDto);
        if (hrRepo.findByLogin(hrModel.getLogin()).isPresent()) {
            throw new RuntimeException("Пользователь уже существует");
        }
        HrResponseDto hrResponseDto = hrMapper.toResponse(hrRepo.save(hrModel));
        return hrResponseDto;
    }

}
