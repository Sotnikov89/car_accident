package ru.accident.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import ru.accident.services.AccidentService;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class IndexControllerTest {

    @Mock
    AccidentService accidentService;
    @Mock
    Authentication authentication;
    @Mock
    SecurityContext context;

    IndexController indexController;

    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        indexController = new IndexController(accidentService);
        mockMvc = MockMvcBuilders.standaloneSetup(indexController).build();
    }

    @Test
    void index() throws Exception {
        when(context.getAuthentication()).thenReturn(authentication);
        SecurityContextHolder.setContext(context);
        mockMvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"))
                .andExpect(model().attributeExists("accidents"));
        verify(accidentService, times(1)).findAll();
    }
}