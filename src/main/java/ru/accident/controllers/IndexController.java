package ru.accident.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class IndexController {
    @GetMapping("/")
    public String index(Model model) {
        List<String> example = List.of("Первый", "Второй", "Третий");
        model.addAttribute("example", example);
        return "index";
    }
}