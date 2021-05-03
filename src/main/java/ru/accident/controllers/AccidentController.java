package ru.accident.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.accident.domain.Accident;
import ru.accident.services.ImplAccidentService;

@Controller
@AllArgsConstructor
public class AccidentController {

    private final ImplAccidentService implAccidentService;

    @GetMapping("/create")
    public String getCreateForm(Model model) {
        model.addAttribute("accident", Accident.builder().build());
        return "accidentForm";
    }

    @GetMapping("/{id}")
    public String getEditForm(@PathVariable int id, Model model) {
        model.addAttribute("accident", implAccidentService.getById(id));
        return "accidentForm";
    }

    @PostMapping("/saveOrUpdate")
    public String saveOrUpdate(@ModelAttribute Accident accident) {
        implAccidentService.saveOrUpdate(accident);
        return "redirect:/index";
    }
}
