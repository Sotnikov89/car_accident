package ru.accident.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import ru.accident.domain.Authority;
import ru.accident.domain.User;
import ru.accident.services.AuthorityService;
import ru.accident.services.UserService;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

class RegControlTest {

    @Mock
    PasswordEncoder encoder;
    @Mock
    UserService userService;
    @Mock
    AuthorityService authorityService;

    RegControl regControl;

    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        regControl = new RegControl(encoder, userService, authorityService);
        mockMvc = MockMvcBuilders.standaloneSetup(regControl).build();
    }

    @Test
    @WithMockUser
    void reg() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/reg"))
                .andExpect(status().isOk())
                .andExpect(view().name("registration"));
    }

    @Test
    void save() throws Exception {
        Authority authority = Authority.builder()
                .authority("ROLE_USER")
                .build();
        when(authorityService.findByAuthority(anyString())).thenReturn(authority);
        User user = User.builder()
                .enabled(true)
                .password(encoder.encode("PASSWORD"))
                .authority(authorityService.findByAuthority("ROLE_USER"))
                .build();
        when(userService.save(any())).thenReturn(true);
        mockMvc.perform(MockMvcRequestBuilders.post("/reg"))
                .andExpect(status().isOk())
                .andExpect(view().name("auth"));
        verify(authorityService, times(2)).findByAuthority(anyString());
        verify(userService, times(1)).save(anyObject());
    }
}