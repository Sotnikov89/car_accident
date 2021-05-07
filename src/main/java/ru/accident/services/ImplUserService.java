package ru.accident.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.accident.domain.User;
import ru.accident.repositories.jpa.UserRepository;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ImplUserService implements UserService{

    private final UserRepository userRepository;

    @Override
    public boolean save(User user) {
        boolean nameFree = Optional.ofNullable(userRepository.findByUsername(user.getUsername())).isEmpty();
        if (nameFree) {
            userRepository.save(user);
        }
        return nameFree;
    }
}
