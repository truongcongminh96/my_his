package com.his.hospital_api.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "SYS_USER_ROLE")
@IdClass(SysUserRoleId.class)
public class SysUserRole {
    @Id
    @Column(name = "USER_ID")
    private Long userId;

    @Id
    @Column(name = "ROLE_ID")
    private Long roleId;
}
