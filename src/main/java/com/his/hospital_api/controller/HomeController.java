package com.his.hospital_api.controller;

import com.his.hospital_api.security.CustomUserDetails;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String home(@AuthenticationPrincipal CustomUserDetails loggedUser, Model model) {
        model.addAttribute("fullName", loggedUser.getUser().getFullName());
        model.addAttribute("username", loggedUser.getUsername());
        model.addAttribute("email", loggedUser.getUser().getEmail());
        model.addAttribute("roles", loggedUser.getAuthorities());
        return "home";
    }
}
