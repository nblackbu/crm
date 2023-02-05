package ru.home.crm.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import ru.home.crm.exception.HrErrorResponse;
import ru.home.crm.exception.HrNotCreatedException;
import ru.home.crm.exception.HrNotFoundException;
import ru.home.crm.model.dto.request.HrRequestDto;
import ru.home.crm.model.dto.response.HrResponseDto;
import ru.home.crm.security.HrDetails;
import ru.home.crm.service.HrServiceImpl;
import java.util.List;

@RestController
@RequestMapping("/v1/hrs")
@RequiredArgsConstructor
@CrossOrigin
public class HrController {

    private final HrServiceImpl hrService;

    @GetMapping("/{id}")
    public ResponseEntity<HrResponseDto> findById(@PathVariable Long id) {
        HrResponseDto hrResponseDto = hrService.findByID(id);
        return new ResponseEntity<>(hrResponseDto, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<HrResponseDto>> allHr() {
        return new ResponseEntity<>(hrService.allHr(), HttpStatus.OK);
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<HttpStatus> create(@RequestBody @Valid HrRequestDto hrRequestDto,
                                                BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            StringBuilder errorMsg = new StringBuilder();
            List<FieldError> fieldErrorList = bindingResult.getFieldErrors();
            for(FieldError fieldError : fieldErrorList) {
                errorMsg.append(fieldError.getField())
                        .append("-").append(fieldError.getDefaultMessage())
                        .append(";"); }
            throw new HrNotCreatedException(errorMsg.toString());
        }
        hrService.save(hrRequestDto);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        hrService.delete(id);
        return new ResponseEntity<>("Пользователь с id " + id + " был успешно удален", HttpStatus.OK);
    }

//    @GetMapping("/showHrInfo")
//    public String showHrInfo() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        HrDetails hrDetails = (HrDetails) authentication.getPrincipal();
//        return null;
//    }


    @PatchMapping(path="/{id}", consumes="application/json")
    public ResponseEntity<HrResponseDto> updateHr(@PathVariable("id") Long id,
                                                  @RequestBody @Valid HrRequestDto hrRequestDto,
                                                  BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            StringBuilder errorMsg = new StringBuilder();
            List<FieldError> fieldErrorList = bindingResult.getFieldErrors();
            for(FieldError fieldError : fieldErrorList) {
                errorMsg.append(fieldError.getField())
                        .append("-").append(fieldError.getDefaultMessage())
                        .append(";"); }
            throw new HrNotCreatedException(errorMsg.toString());
        }
        return new ResponseEntity<>(hrService.update(hrRequestDto), HttpStatus.OK);
    }


    @ExceptionHandler
    private ResponseEntity<HrErrorResponse> handleException(HrNotFoundException e) {
        HrErrorResponse response = new HrErrorResponse(
                "Hr с таким id не был найден",
                System.currentTimeMillis());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    private ResponseEntity<HrErrorResponse> handleException(HrNotCreatedException e) {
        HrErrorResponse response = new HrErrorResponse(e.getMessage(), System.currentTimeMillis());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
