package ru.accident.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.accident.services.ImplAccidentService;


@Controller
@AllArgsConstructor
public class IndexController {
    private final ImplAccidentService implAccidentService;

    @GetMapping({"/", "/index"})
    public String index(Model model) {
        model.addAttribute("accidents", implAccidentService.findAll());
        return "index";
    }
}