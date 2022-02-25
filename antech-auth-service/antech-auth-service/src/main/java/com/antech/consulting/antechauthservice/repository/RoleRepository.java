package com.antech.consulting.antechauthservice.repository;

import com.antech.consulting.antechauthservice.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByRoleId(String roleId);
}
