package com.antech.consulting.antechauthservice.controller;

import com.antech.consulting.antechauthservice.dto.RoleDto;
import com.antech.consulting.antechauthservice.entity.Role;
import com.antech.consulting.antechauthservice.mapper.RoleMapper;
import com.antech.consulting.antechauthservice.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/role")
@AllArgsConstructor
public class RoleController {

    @Autowired
    public final RoleService roleService;

    @Autowired
    private RoleMapper roleMapper;

    @GetMapping()
    public ResponseEntity<List<RoleDto>> getRoles()  {
        return new ResponseEntity<>(roleMapper.modelsToDtos(roleService.getRoles()), HttpStatus.OK);
    }

    @GetMapping("{roleId}")
    public ResponseEntity<RoleDto> getRoleById(@PathVariable String roleId)  {
        return new ResponseEntity<>(roleMapper.modelToDto(roleService.getRoleById(roleId)), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<RoleDto> createRole(@RequestBody Role role)  {
        return new ResponseEntity<>(roleMapper.modelToDto(roleService.createRole(role)), HttpStatus.CREATED);
    }
}
