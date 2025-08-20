package com.his.hospital_api.repository;

import com.his.hospital_api.entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalRepository extends JpaRepository<Hospital, Long> {
    boolean existsByCode(String code);
}
