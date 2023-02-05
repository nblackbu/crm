package ru.home.crm.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.home.crm.exception.NoSuchUserException;
import ru.home.crm.model.dto.request.HrRequestDto;
import ru.home.crm.model.dto.request.HrUpdateRequestDto;
import ru.home.crm.model.dto.response.HrResponseDto;
import ru.home.crm.service.HrServiceImpl;

@RestController
@RequestMapping("/v1/hrs")
@RequiredArgsConstructor
@CrossOrigin
public class HrController {

    private final HrServiceImpl hrService;

    @GetMapping("/{id}")
    public ResponseEntity<HrResponseDto> findById(@PathVariable Long id) {
        HrResponseDto hrResponseDto = hrService.findByID(id);
        if (hrResponseDto == null)
            throw new NoSuchUserException("Пользователь с таким " + id + " не был найден");
        return new ResponseEntity<>(hrResponseDto, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Page<HrResponseDto>> findAll(@PageableDefault(size = 3) Pageable pageable) {
        return new ResponseEntity<>(hrService.findAll(pageable), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<HrResponseDto> create(@RequestBody @Valid HrRequestDto hrRequestDto) {
        HrResponseDto hrResponseDto = hrService.create(hrRequestDto);
        return new ResponseEntity<>(hrResponseDto, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        hrService.delete(id);
        return new ResponseEntity<>("Пользователь с id " + id + " был успешно удален", HttpStatus.OK);
    }

//    @GetMapping("/showHrInfo")
//    public String showHrInfo() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        HrDetails hrDetails = (HrDetails) authentication.getPrincipal();
//        return null;
//    }


    @PatchMapping(path="/{id}")
    public ResponseEntity<HrResponseDto> updateHr(@PathVariable("id") Long id,
                                                  @RequestBody @Valid HrUpdateRequestDto hrUpdateRequestDto) {
        HrResponseDto hrResponseDto = hrService.update(id, hrUpdateRequestDto);
        return new ResponseEntity<>(hrResponseDto, HttpStatus.OK);
    }
}
