package com.antech.consulting.antechauthservice.service;

import com.antech.consulting.antechauthservice.entity.AppUser;
import com.antech.consulting.antechauthservice.entity.RegisterUserConfirmation;
import com.antech.consulting.antechauthservice.mapper.RegisterUserMapper.AppUserMapper;
import com.antech.consulting.antechauthservice.repository.AppUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
//@RequiredArgsConstructor(onConstructor_ = @Lazy)
@AllArgsConstructor
public class AppUserService {
    private final AppUserRepository appUserRepository;
    private final AppUserMapper mapper;

    public RegisterUserConfirmation createAppUser(AppUser userToCreate){
        //ADD VALIDATION THAT USERNAME IS UNIQUE
        userToCreate.setUuid(null);
        userToCreate.setRoles(null);
        //ADD TO USER-ROLE TABLE
        //CHECK FOR PASSWORD REQUIREMENTS
        //HASH PASSWORD BEFORE SAVING
        appUserRepository.save(userToCreate);
        return mapper.appUserToConfirmation(userToCreate);
    }
}
