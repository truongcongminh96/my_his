package com.his.hospital_api.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "SYS_ROLE")
public class SysRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ROLE_ID")
    private Long roleId;

    @Column(name = "CODE", length = 50, unique = true)
    private String code;

    @Column(name = "NAME", length = 100)
    private String name;

    @ManyToMany(mappedBy = "roles")
    private Set<SysUser> users;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
