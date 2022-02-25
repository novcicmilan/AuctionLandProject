package com.antech.consulting.antechauthservice.repository;

import com.antech.consulting.antechauthservice.entity.AppUser;
import com.antech.consulting.antechauthservice.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface AppUserRepository extends JpaRepository<AppUser, String> {
    Set<Role> findByAppUserUsername(String appUserUsername);
}
