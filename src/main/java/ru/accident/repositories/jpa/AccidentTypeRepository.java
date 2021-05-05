package ru.accident.repositories.jpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.accident.domain.AccidentType;

@Repository
public interface AccidentTypeRepository extends CrudRepository<AccidentType, Integer> {
}
