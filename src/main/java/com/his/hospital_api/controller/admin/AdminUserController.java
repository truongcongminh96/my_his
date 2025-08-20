package com.his.hospital_api.controller.admin;

import com.his.hospital_api.repository.HospitalRepository;
import com.his.hospital_api.repository.SysRoleRepository;
import com.his.hospital_api.repository.SysUserRepository;
import com.his.hospital_api.service.UserAdminService;
import com.his.hospital_api.web.dto.CreateUserForm;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/users")
public class AdminUserController {

    private final SysUserRepository userRepo;
    private final HospitalRepository hospitalRepo;
    private final SysRoleRepository roleRepo;
    private final UserAdminService userAdminService;

    public AdminUserController(SysUserRepository userRepo,
                               HospitalRepository hospitalRepo,
                               SysRoleRepository roleRepo,
                               UserAdminService userAdminService) {
        this.userRepo = userRepo;
        this.hospitalRepo = hospitalRepo;
        this.roleRepo = roleRepo;
        this.userAdminService = userAdminService;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("users", userRepo.findAll());
        return "admin/users/list";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("form", new CreateUserForm());
        model.addAttribute("hospitals", hospitalRepo.findAll());
        model.addAttribute("roles", roleRepo.findAll());
        return "admin/users/create";
    }

    @PostMapping
    public String create(@Valid @ModelAttribute("form") CreateUserForm form,
                         BindingResult binding, Model model) {
        if (binding.hasErrors()) {
            model.addAttribute("hospitals", hospitalRepo.findAll());
            model.addAttribute("roles", roleRepo.findAll());
            return "admin/users/create";
        }

        if (!form.getPassword().equals(form.getConfirmPassword())) {
            binding.rejectValue("confirmPassword", "invalid", "Mật khẩu nhập lại không khớp");
            model.addAttribute("hospitals", hospitalRepo.findAll());
            model.addAttribute("roles", roleRepo.findAll());
            return "admin/users/create";
        }

        try {
            userAdminService.createUser(form);
            return "redirect:/admin/users?success";
        } catch (IllegalArgumentException ex) {
            binding.rejectValue("username", "invalid", ex.getMessage());
            model.addAttribute("hospitals", hospitalRepo.findAll());
            model.addAttribute("roles", roleRepo.findAll());
            return "admin/users/create";
        }
    }
}
