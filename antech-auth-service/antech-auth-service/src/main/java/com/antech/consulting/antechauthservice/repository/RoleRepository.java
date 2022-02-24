package com.antech.consulting.antechauthservice.repository;

import com.antech.consulting.antechauthservice.entity.AppUserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<AppUserRole, Long> {

}
