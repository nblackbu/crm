package ru.home.crm.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.home.crm.model.dto.response.HrResponseDto;
import ru.home.crm.service.HrServiceImpl;

//RequestMapping позволяет задать шаблон в url методе

@RestController
@RequestMapping("/v1/hrs")
@RequiredArgsConstructor
public class HrController {

    private final HrServiceImpl hrService;

    @GetMapping("/{id}")
    public ResponseEntity<HrResponseDto> findById(@PathVariable Long id) {
        HrResponseDto hrResponseDto = hrService.findByID(id);
//        if (); security, swing, rnonull - check
        return new ResponseEntity<>(hrResponseDto, HttpStatus.OK);
    }
}
