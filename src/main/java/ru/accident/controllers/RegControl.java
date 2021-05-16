package ru.accident.controllers;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.accident.domain.User;
import ru.accident.services.AuthorityService;
import ru.accident.services.UserService;

@Controller
@AllArgsConstructor
public class RegControl {

    private final PasswordEncoder encoder;
    private final UserService userService;
    private final AuthorityService authorityService;

    @GetMapping("/reg")
    public String reg() {
        return "registration";
    }

    @PostMapping("/reg")
    public String save(@ModelAttribute User user, Model model) {
        user.setEnabled(true);
        user.setPassword(encoder.encode(user.getPassword()));
        user.setAuthority(authorityService.findByAuthority("ROLE_USER"));
        boolean rsl = userService.save(user);
        if (!rsl) {
            model.addAttribute("errorMessage", "Username is exist !!!");
        }
        return rsl? "auth" : "registration";
    }
}
