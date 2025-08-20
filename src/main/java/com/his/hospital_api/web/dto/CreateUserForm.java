package com.his.hospital_api.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class CreateUserForm {
    @NotBlank
    private String username;
    @NotBlank
    private String password;
    @NotBlank
    private String confirmPassword;
    @NotBlank
    private String fullName;
    private String email;
    private String phone;
    @NotNull
    private Long hospitalId;
    private List<String> roleCodes;
    private boolean active = true;

    // getters/setters
    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public String getConfirmPassword() {
        return this.confirmPassword;
    }

    public String getFullName() {
        return this.fullName;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPhone() {
        return this.phone;
    }

    public boolean isActive() {
        return active;
    }

    public Long getHospitalId() {
        return this.hospitalId;
    }

    public List<String> getRoleCodes() {
        return this.roleCodes;
    }

    public void setUsername(String v){ this.username = v; }
}
