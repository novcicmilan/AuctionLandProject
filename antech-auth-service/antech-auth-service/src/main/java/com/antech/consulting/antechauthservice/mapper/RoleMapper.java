package com.antech.consulting.antechauthservice.mapper;

import com.antech.consulting.antechauthservice.dto.Role.RoleDto;
import com.antech.consulting.antechauthservice.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    RoleMapper INSTANCE= Mappers.getMapper(RoleMapper.class);

    RoleDto modelToDto(Role role);
    Role modelToModel(Role role);
    Role dtoToModel(RoleDto roleDto);
    List<RoleDto> modelsToDtos(List<Role> roles);
}
