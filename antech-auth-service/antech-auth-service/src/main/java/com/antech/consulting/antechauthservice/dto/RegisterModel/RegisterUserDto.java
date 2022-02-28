package com.antech.consulting.antechauthservice.dto.RegisterModel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterUserDto {

    @NotNull
    private String username;
    @NotNull
    private String password;
}

