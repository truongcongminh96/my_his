package com.his.hospital_api.repository;

import com.his.hospital_api.entity.SysRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SysRoleRepository extends JpaRepository<SysRole, Long> {
    SysRole findByCode(String code);
}
