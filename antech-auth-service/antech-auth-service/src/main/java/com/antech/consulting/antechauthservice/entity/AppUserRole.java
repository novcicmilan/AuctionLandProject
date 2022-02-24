package com.antech.consulting.antechauthservice.entity;

import com.antech.consulting.antechauthservice.constants.AntechAuthenticationDbConstants;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = AntechAuthenticationDbConstants.AppUserRole)
public class AppUserRole {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleId;

    @Column
    private String roleName;
}
