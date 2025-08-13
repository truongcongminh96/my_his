package com.his.hospital_api.service;

import com.his.hospital_api.entity.SysUser;
import com.his.hospital_api.repository.SysUserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class AuthService {

    private final SysUserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public AuthService(SysUserRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public SysUser login(String username, String password) {
        Optional<SysUser> userOpt = userRepository.findByUsername(username);
        if (userOpt.isPresent()) {
            SysUser user = userOpt.get();
            if (passwordEncoder.matches(password, user.getPasswordHash()) && user.getIsActive() == 1) {
                return user;
            }
        }
        return null;
    }
}
