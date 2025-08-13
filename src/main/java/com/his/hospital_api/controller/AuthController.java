package com.his.hospital_api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

    @GetMapping("/authentication/login")
    public String login() { return "authentication/login"; }
}
