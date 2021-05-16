package ru.accident.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ru.accident.domain.Authority;
import ru.accident.repositories.jpa.AuthorityRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class ImplAuthorityServiceTest {

    @Mock
    AuthorityRepository authorityRepository;

    AuthorityService authorityService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        authorityService = new ImplAuthorityService(authorityRepository);
    }

    @Test
    void findByAuthority() {
        Authority authority = Authority.builder().id(1).authority("ROLE_USER").build();
        when(authorityRepository.findByAuthority(anyString())).thenReturn(authority);
        Authority returnAuthority = authorityService.findByAuthority("ROLE_USER");

        verify(authorityRepository, times(1)).findByAuthority(anyString());
        assertEquals(returnAuthority.getAuthority(), "ROLE_USER");
        assertEquals(returnAuthority.getId(), 1);
    }
}