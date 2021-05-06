package ru.accident.repositories.jpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.accident.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
}
