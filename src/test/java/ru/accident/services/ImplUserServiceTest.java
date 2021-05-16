package ru.accident.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ru.accident.domain.User;
import ru.accident.repositories.jpa.UserRepository;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class ImplUserServiceTest {

    @Mock
    UserRepository userRepository;

    UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        userService = new ImplUserService(userRepository);
    }

    @Test
    void save() {
        User user = User.builder().id(3).username("name").build();
        when(userRepository.save(any())).thenReturn(true);
        userService.save(user);

        verify(userRepository,times(1)).save(any());
    }
}