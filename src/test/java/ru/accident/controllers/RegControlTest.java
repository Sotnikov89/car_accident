package ru.accident.controllers;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import ru.accident.AccidentApplication;
import ru.accident.services.AuthorityService;
import ru.accident.services.UserService;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest(classes = AccidentApplication.class)
@AutoConfigureMockMvc
class RegControlTest {

    @Mock
    PasswordEncoder encoder;
    @Mock
    UserService userService;
    @Mock
    AuthorityService authorityService;

    @Autowired
    MockMvc mockMvc;

    @Test
    @WithMockUser
    void reg() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/reg"))
                .andExpect(status().isOk())
                .andExpect(view().name("reg"));
    }

    @Test
    void save() throws Exception {
        /*
        Authority authority = Authority.builder()
                .authority("ROLE_USER")
                .build();
        when(authorityService.findByAuthority(anyString())).thenReturn(authority);
        User user = User.builder()
                .enabled(true)
                .password(encoder.encode("PASSWORD"))
                .authority(authorityService.findByAuthority("ROLE_USER"))
                .build();
        mockMvc.perform(MockMvcRequestBuilders.post("/reg"))
                .andExpect(status().isOk())
                .andExpect(view().name("redirect:/login"));
        verify(authorityService, times(1)).findByAuthority(anyString());
        verify(userService, times(1)).save(anyObject());
        */

    }
}