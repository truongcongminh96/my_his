package com.his.hospital_api.repository;

import com.his.hospital_api.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface SysUserRepository extends JpaRepository<SysUser, Long> {
    @Query("SELECT u FROM SysUser u LEFT JOIN FETCH u.roles WHERE u.username = :username")
    Optional<SysUser> findByUsername(String username);
}
