package com.his.hospital_api.service;

import com.his.hospital_api.entity.Hospital;
import com.his.hospital_api.entity.SysRole;
import com.his.hospital_api.entity.SysUser;
import com.his.hospital_api.repository.HospitalRepository;
import com.his.hospital_api.repository.SysRoleRepository;
import com.his.hospital_api.repository.SysUserRepository;
import com.his.hospital_api.web.dto.CreateUserForm;
import jakarta.transaction.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class UserAdminService {

    private final SysUserRepository userRepo;
    private final HospitalRepository hospitalRepo;
    private final SysRoleRepository roleRepo;
    private final PasswordEncoder encoder;

    public UserAdminService(SysUserRepository userRepo,
                            HospitalRepository hospitalRepo,
                            SysRoleRepository roleRepo,
                            PasswordEncoder encoder) {
        this.userRepo = userRepo;
        this.hospitalRepo = hospitalRepo;
        this.roleRepo = roleRepo;
        this.encoder = encoder;
    }

    @Transactional
    public SysUser createUser(CreateUserForm form) {
        if (userRepo.existsByUsername(form.getUsername())) {
            throw new IllegalArgumentException("Username đã tồn tại");
        }

        Hospital hospital = hospitalRepo.findById(form.getHospitalId())
                .orElseThrow(() -> new IllegalArgumentException("Hospital không hợp lệ"));

        var roles = new HashSet<SysRole>();
        if (form.getRoleCodes() != null) {
            for (String code : form.getRoleCodes()) {
                roles.add(roleRepo.findByCode(code)
                        .orElseThrow(() -> new IllegalArgumentException("Role không hợp lệ: " + code)));
            }
        }

        SysUser u = new SysUser();
        u.setUsername(form.getUsername());
        u.setPasswordHash(encoder.encode(form.getPassword()));
        u.setFullName(form.getFullName());
        u.setEmail(form.getEmail());
        u.setPhone(form.getPhone());
        u.setIsActive(form.isActive() ? 1 : 0);
        u.setHospital(hospital);
        u.setRoles(roles);

        return userRepo.save(u);
    }
}
