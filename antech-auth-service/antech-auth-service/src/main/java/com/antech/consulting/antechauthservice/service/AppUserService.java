package com.antech.consulting.antechauthservice.service;

import com.antech.consulting.antechauthservice.repository.AppUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor_ = @Lazy)
public class AppUserService {
    private final AppUserRepository appUserRepository;


}
