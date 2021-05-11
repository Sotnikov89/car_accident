package ru.accident.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.accident.domain.Accident;
import ru.accident.services.AccidentService;
import ru.accident.services.AccidentTypeService;
import ru.accident.services.RuleService;

import javax.servlet.http.HttpServletRequest;

@Controller
@AllArgsConstructor
public class AccidentController {

    private final AccidentService accidentService;
    private final AccidentTypeService typeService;
    private final RuleService ruleService;

    @GetMapping("/create")
    public String getCreateForm(Model model) {
        model.addAttribute("accident", Accident.builder().build());
        model.addAttribute("types", typeService.findAll());
        model.addAttribute("rules", ruleService.findAll());
        return "accidentForm";
    }

    @GetMapping("/update/{id}")
    public String getEditForm(@PathVariable int id, Model model) {
        model.addAttribute("accident", accidentService.findById(id));
        model.addAttribute("types", typeService.findAll());
        model.addAttribute("rules", ruleService.findAll());
        return "accidentForm";
    }

    @PostMapping("/saveOrUpdate")
    public String saveOrUpdate(@ModelAttribute Accident accident, HttpServletRequest req) {
        String[] rulesId = req.getParameterValues("rIds");
        accidentService.saveOrUpdate(accident, rulesId);
        return "redirect:/index";
    }
}
