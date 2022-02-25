package com.antech.consulting.antechauthservice.controller;

import com.antech.consulting.antechauthservice.dto.RegisterModel.RegisterConfirmationDto;
import com.antech.consulting.antechauthservice.dto.RegisterModel.RegisterUserDto;
import com.antech.consulting.antechauthservice.entity.AppUser;
import com.antech.consulting.antechauthservice.entity.RegisterUserConfirmation;
import com.antech.consulting.antechauthservice.mapper.RegisterUserMapper.AppUserMapper;
import com.antech.consulting.antechauthservice.service.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@AllArgsConstructor
@RestController
@RequestMapping("/api/user/registration")
public class AppUserRegistrationController {

    private AppUserService appUserService;
    private AppUserMapper mapper;

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<RegisterConfirmationDto> registerNewUser(@RequestBody RegisterUserDto user){
        AppUser mappedObj = mapper.registerUserToAppUser(user);
        RegisterUserConfirmation confirmation = appUserService.createAppUser(mappedObj);
        return new ResponseEntity<>(mapper.registerConfirmationToDto(confirmation), HttpStatus.OK);
    }
}
