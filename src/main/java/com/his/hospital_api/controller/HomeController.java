package com.his.hospital_api.controller;

import com.his.hospital_api.security.CustomUserDetails;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.stream.Collectors;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String home(Authentication authentication, Model model) {
        CustomUserDetails principal = (CustomUserDetails) authentication.getPrincipal();

        var roles = principal.getAuthorities()
                .stream()
                .map(a -> a.getAuthority())
                .collect(Collectors.toList());

        model.addAttribute("username", principal.getUsername());
        model.addAttribute("fullName", principal.getUser().getFullName());
        model.addAttribute("email", principal.getUser().getEmail());
        model.addAttribute("hospitalId", principal.getUser().getHospitalId());
        model.addAttribute("roles", roles);

        return "home";
    }
}
