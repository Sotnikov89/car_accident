package ru.accident.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.accident.domain.Accident;
import ru.accident.services.ImplAccidentService;
import ru.accident.services.ImplAccidentTypeService;

@Controller
@AllArgsConstructor
public class AccidentController {

    private final ImplAccidentService accidentService;
    private final ImplAccidentTypeService typeService;

    @GetMapping("/create")
    public String getCreateForm(Model model) {
        model.addAttribute("accident", Accident.builder().build());
        model.addAttribute("types", typeService.findAll());
        return "accidentForm";
    }

    @GetMapping("/{id}")
    public String getEditForm(@PathVariable int id, Model model) {
        model.addAttribute("accident", accidentService.getById(id));
        model.addAttribute("types", typeService.findAll());
        return "accidentForm";
    }

    @PostMapping("/saveOrUpdate")
    public String saveOrUpdate(@ModelAttribute Accident accident) {
        accidentService.saveOrUpdate(accident);
        return "redirect:/index";
    }
}
