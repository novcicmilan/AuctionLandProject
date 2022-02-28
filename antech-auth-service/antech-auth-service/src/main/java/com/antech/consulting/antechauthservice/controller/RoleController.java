package com.antech.consulting.antechauthservice.controller;

import com.antech.consulting.antechauthservice.dto.Role.RoleDto;
import com.antech.consulting.antechauthservice.entity.Role;
import com.antech.consulting.antechauthservice.mapper.RoleMapper;
import com.antech.consulting.antechauthservice.service.RoleService;
import javassist.NotFoundException;
import javassist.bytecode.DuplicateMemberException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<Object> getRoles()  {
        List<RoleDto> roles = roleMapper.modelsToDtos(roleService.getRoles());
        if(roles == null || roles.size()==0)
        {
            return new ResponseEntity<>("No roles added yet!", HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(roles, HttpStatus.OK);
    }

    @GetMapping("{roleId}")
    public ResponseEntity<Object> getRoleById(@PathVariable String roleId)  {

        try{
            RoleDto roleById = roleMapper.modelToDto(roleService.getRoleById(roleId));
            return new ResponseEntity<>(roleById, HttpStatus.OK);
        }
        catch (NotFoundException ex) {
            return new ResponseEntity<>("There is no role with this ID!", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping()
    public ResponseEntity<Object> createRole(@RequestBody Role role) {

        try {
            RoleDto newRole = roleMapper.modelToDto(roleService.createRole(role));

            return new ResponseEntity<>(newRole, HttpStatus.CREATED);
        }
        catch(DuplicateMemberException ex) {
            return new ResponseEntity<>("Role you tried to create already exists!", HttpStatus.NO_CONTENT);
        }
    }

    @PutMapping("{roleId}")
    public ResponseEntity<Object> updateRole(@PathVariable String roleId, @RequestBody RoleDto role) {
        try{
            roleMapper.modelToDto(roleService.updateRole(role, roleId));
            return new ResponseEntity<>(role, HttpStatus.OK);
        }
        catch (NotFoundException ex) {
            return new ResponseEntity<>("It is not possible to update this role, because role with same name already exists or role with this ID doesn't exist!", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("{roleId}")
    public ResponseEntity<Object> deleteRole(@PathVariable String roleId) {
        try{
            roleService.deleteRole(roleId);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (NotFoundException ex) {
            return new ResponseEntity<>("Deleting is not possible, because role with this ID doesn't exist!", HttpStatus.NOT_FOUND);
        }
    }
}
