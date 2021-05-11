package ru.accident.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import ru.accident.domain.Accident;
import ru.accident.domain.AccidentType;
import ru.accident.domain.Rule;
import ru.accident.services.AccidentService;
import ru.accident.services.AccidentTypeService;
import ru.accident.services.RuleService;

import java.util.Set;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class AccidentControllerTest {

    @Mock
    AccidentService accidentService;
    @Mock
    AccidentTypeService accidentTypeService;
    @Mock
    RuleService ruleService;

    AccidentController accidentController;

    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        accidentController = new AccidentController(accidentService, accidentTypeService, ruleService);
        mockMvc = MockMvcBuilders.standaloneSetup(accidentController).build();
    }

    @Test
    void getCreateForm() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/create"))
                .andExpect(status().isOk())
                .andExpect(view().name("accidentForm"))
                .andExpect(model().attributeExists("accident"))
                .andExpect(model().attributeExists("types"))
                .andExpect(model().attributeExists("rules"));
        verify(accidentTypeService, times(1)).findAll();
        verify(ruleService, times(1)).findAll();
    }

    @Test
    void getEditForm() throws Exception {
        Rule rule1 = Rule.builder().id(1).name("St 1").build();
        Rule rule2 = Rule.builder().id(2).name("St 2").build();
        AccidentType accidentType = AccidentType.builder().id(3).name("Two cars").build();
        Accident accident = Accident.builder()
                .id(1)
                .name("Vadim")
                .address("Moscow")
                .text("Description")
                .accidentType(accidentType)
                .rules(Set.of(rule1, rule2))
                .build();
        when(accidentService.findById(anyInt())).thenReturn(accident);
        mockMvc.perform(MockMvcRequestBuilders.get("/update/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("accidentForm"))
                .andExpect(model().attributeExists("accident"))
                .andExpect(model().attributeExists("types"))
                .andExpect(model().attributeExists("rules"));
        verify(accidentService, times(1)).findById(anyInt());
        verify(accidentTypeService, times(1)).findAll();
        verify(ruleService, times(1)).findAll();
    }

    @Test
    void saveOrUpdate() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/saveOrUpdate"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/index"));
    }
}