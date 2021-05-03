package ru.accident.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.accident.domain.Accident;
import ru.accident.services.ImplAccidentService;
import ru.accident.services.ImplAccidentTypeService;
import ru.accident.services.ImplRuleService;

import javax.servlet.http.HttpServletRequest;
import java.net.http.HttpRequest;
import java.util.Arrays;

@Controller
@AllArgsConstructor
public class AccidentController {

    private final ImplAccidentService accidentService;
    private final ImplAccidentTypeService typeService;
    private final ImplRuleService ruleService;

    @GetMapping("/create")
    public String getCreateForm(Model model) {
        model.addAttribute("accident", Accident.builder().build());
        model.addAttribute("types", typeService.findAll());
        model.addAttribute("rules", ruleService.findAll());
        return "accidentForm";
    }

    @GetMapping("/update/{id}")
    public String getEditForm(@PathVariable int id, Model model) {
        model.addAttribute("accident", accidentService.getById(id));
        model.addAttribute("types", typeService.findAll());
        model.addAttribute("rules", ruleService.findAll());
        return "accidentForm";
    }

    @PostMapping("/saveOrUpdate")
    public String saveOrUpdate(@ModelAttribute Accident accident, HttpServletRequest req) {
        String[] rulesId = req.getParameterValues("rIds");
        Arrays.stream(rulesId).map(Integer::parseInt).map(ruleService::findById).forEach(accident::addRule);
        accidentService.saveOrUpdate(accident);
        return "redirect:/index";
    }
}
