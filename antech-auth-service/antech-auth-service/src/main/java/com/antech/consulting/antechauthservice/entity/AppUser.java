package com.antech.consulting.antechauthservice.entity;

import com.antech.consulting.antechauthservice.constants.AntechAuthenticationColumnConstants;
import com.antech.consulting.antechauthservice.constants.AntechAuthenticationDbConstants;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = AntechAuthenticationDbConstants.AppUser)
public class AppUser {
    @Id
    @EqualsAndHashCode.Include
    private String appUserUsername;

    @Column(nullable = false)
    private String appUserPassword;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = AntechAuthenticationDbConstants.AppUser_UserRole,
            joinColumns = @JoinColumn(name = AntechAuthenticationColumnConstants.FK_AppUser_Id),
            inverseJoinColumns = @JoinColumn(name = AntechAuthenticationColumnConstants.FK_UserRole_Id)
    )
    private Set<AppUserRole> roles;

}
