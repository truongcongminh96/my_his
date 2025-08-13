package com.his.hospital_api.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "SYS_USER")
public class SysUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Long userId;

    @Column(name = "USERNAME", nullable = false, unique = true, length = 100)
    private String username;

    @Column(name = "PASSWORD_HASH", nullable = false, length = 255)
    private String passwordHash;

    @Column(name = "FULL_NAME", length = 255)
    private String fullName;

    @Column(name = "EMAIL", length = 150)
    private String email;

    @Column(name = "PHONE", length = 20)
    private String phone;

    @Column(name = "IS_ACTIVE", columnDefinition = "NUMBER(1)")
    private Integer isActive;

    @Column(name = "HOSPITAL_ID", nullable = false)
    private Long hospitalId;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "SYS_USER_ROLE",
            joinColumns = @JoinColumn(name = "USER_ID"),
            inverseJoinColumns = @JoinColumn(name = "ROLE_ID")
    )
    private Set<SysRole> roles;

    public Set<SysRole> getRoles() {
        return roles;
    }

    public void setRoles(Set<SysRole> roles) {
        this.roles = roles;
    }

    public Integer getIsActive() {
        return this.isActive;
    }

    public String getUsername() {
        return this.username;
    }

    public String getFullName() {
        return this.fullName;
    }

    public String getEmail() {
        return this.email;
    }

    public Long getHospitalId() {
        return this.hospitalId;
    }

    public String getPasswordHash() {
        return this.passwordHash;
    }
}
