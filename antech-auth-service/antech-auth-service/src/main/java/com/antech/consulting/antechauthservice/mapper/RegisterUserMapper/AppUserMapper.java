package com.antech.consulting.antechauthservice.mapper.RegisterUserMapper;

import com.antech.consulting.antechauthservice.dto.RegisterModel.RegisterConfirmationDto;
import com.antech.consulting.antechauthservice.dto.RegisterModel.RegisterUserDto;
import com.antech.consulting.antechauthservice.entity.AppUser;
import com.antech.consulting.antechauthservice.entity.RegisterUserConfirmation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AppUserMapper {

    AppUserMapper INSTANCE = Mappers.getMapper(AppUserMapper.class);

    @Mapping(source = "registerUser.username", target = "appUserUsername")
    @Mapping(source = "registerUser.password", target = "appUserPassword")
    AppUser registerUserToAppUser(RegisterUserDto registerUser);

    @Mapping(source = "user.appUserUsername", target = "username")
    RegisterUserConfirmation appUserToConfirmation(AppUser user);

    RegisterConfirmationDto registerConfirmationToDto(RegisterUserConfirmation confirmation);
}
