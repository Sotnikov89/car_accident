package ru.accident.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.accident.domain.User;
import ru.accident.repositories.jpa.UserRepository;

@Service
@AllArgsConstructor
public class ImplUserService implements UserService{

    private final UserRepository userRepository;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }
}
