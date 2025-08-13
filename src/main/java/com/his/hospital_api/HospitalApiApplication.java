package com.his.hospital_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.SpringVersion;

@SpringBootApplication
public class HospitalApiApplication {

    public static void main(String[] args) {
        System.out.println("Spring version: " + SpringVersion.getVersion());
        SpringApplication.run(HospitalApiApplication.class, args);
    }
}
