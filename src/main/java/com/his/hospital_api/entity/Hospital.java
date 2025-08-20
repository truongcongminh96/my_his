package com.his.hospital_api.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "HOSPITAL")
public class Hospital {
    @Id
    @Column(name = "HOSPITAL_ID")
    private Long hospitalId;

    @Column(name = "CODE", length = 20)
    private String code;
    @Column(name = "NAME", length = 255)
    private String name;
    @Column(name = "HOSPITAL_LEVEL")
    private Integer level; // 1/2/3
    @Column(name = "ADDRESS")
    private String address;
    @Column(name = "PHONE")
    private String phone;

    public Long getHospitalId() { return hospitalId; }
    public String getName() { return name; }
}
