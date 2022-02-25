package com.antech.consulting.antechauthservice.entity;

import com.antech.consulting.antechauthservice.constants.AntechAuthenticationDbConstants;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = AntechAuthenticationDbConstants.Role)
public class Role {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private String roleId;

    @Column
    private String roleName;
}
