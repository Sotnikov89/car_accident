package ru.accident.controllers;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.accident.domain.User;
import ru.accident.services.ImplAuthorityService;
import ru.accident.services.ImplUserService;

@Controller
@AllArgsConstructor
public class RegControl {

    private final PasswordEncoder encoder;
    private final ImplUserService implUserService;
    private final ImplAuthorityService implAuthorityService;

    @GetMapping("/reg")
    public String reg() {
        return "reg";
    }

    @PostMapping("/reg")
    public String save(@ModelAttribute User user, Model model) {
        user.setEnabled(true);
        user.setPassword(encoder.encode(user.getPassword()));
        user.setAuthority(implAuthorityService.findByAuthority("ROLE_USER"));
        String page = "redirect:/login";
        if (!implUserService.save(user)) {
            model.addAttribute("errorMessage", "Username is exist !!");
            page = "/reg";
        }
        return page;
    }
}
