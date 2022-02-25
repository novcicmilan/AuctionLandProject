package com.antech.consulting.antechauthservice.service;

import com.antech.consulting.antechauthservice.dto.RoleDto;
import com.antech.consulting.antechauthservice.entity.Role;
import com.antech.consulting.antechauthservice.mapper.RoleMapper;
import com.antech.consulting.antechauthservice.repository.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RoleService {

    @Autowired
    private final RoleRepository roleRepository;

    public List<Role> getRoles() {
        return roleRepository.findAll();
    }

    public Role getRoleById(String roleId) {
        return roleRepository.findByRoleId(roleId);
    }

    public Role createRole(Role role){
        return roleRepository.save(role);
    }
}
