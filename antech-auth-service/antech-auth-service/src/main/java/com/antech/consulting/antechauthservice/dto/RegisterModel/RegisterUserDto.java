package com.antech.consulting.antechauthservice.dto.RegisterModel;

import com.antech.consulting.antechauthservice.entity.AppUserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

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

