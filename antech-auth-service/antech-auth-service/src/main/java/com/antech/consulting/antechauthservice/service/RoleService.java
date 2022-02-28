package com.antech.consulting.antechauthservice.service;

import com.antech.consulting.antechauthservice.dto.Role.RoleDto;
import com.antech.consulting.antechauthservice.entity.Role;
import com.antech.consulting.antechauthservice.mapper.RoleMapper;
import com.antech.consulting.antechauthservice.repository.RoleRepository;
import javassist.NotFoundException;
import javassist.bytecode.DuplicateMemberException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RoleService {

    @Autowired
    private final RoleRepository roleRepository;

    @Autowired
    private RoleMapper roleMapper;

    public List<Role> getRoles() {
        return roleRepository.findAll();
    }

    public Role getRoleById(String roleId) throws NotFoundException{
        Role role = roleRepository.findByRoleId(roleId);

        if( role == null) {
            throw new NotFoundException("There is no role with this ID!");
        }

        return role;
    }

    public Role createRole(Role role) throws DuplicateMemberException {
        Role roleCheck = roleRepository.findByRoleName(role.getRoleName());

        if(roleCheck != null)
        {
            throw new DuplicateMemberException("There is already role with this");
        }

        //Set uuid to null, because hibernate must know that he needs to generate uuid for new role
        role.setRoleId(null);

        return roleRepository.save(role);
    }

    public Role updateRole(RoleDto newRole, String roleId) throws NotFoundException {
        Role oldRole = roleRepository.findByRoleId(roleId);
        Role checkRole = roleRepository.findByRoleName(newRole.getRoleName());

        if(oldRole == null || checkRole != null) {
            throw new NotFoundException("There is no role with that ID or there is already role with that name!");
        }

        Role updatedRole = roleMapper.dtoToModel(newRole);
        updatedRole.setRoleId(roleId);

        return roleRepository.save(updatedRole);
    }

    public void deleteRole(String roleId) throws NotFoundException {
        Role deleteRole = roleRepository.findByRoleId(roleId);

        if(deleteRole == null) {
            throw new NotFoundException("Role with this ID doesn't exist!");
        }

        roleRepository.delete(deleteRole);
    }
}
