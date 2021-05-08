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
    public boolean save(User user) {
        boolean rsl = false;
        try {
            userRepository.save(user);
            rsl = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rsl;
    }
}
