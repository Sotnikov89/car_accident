package ru.accident.repositories.jpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.accident.domain.Accident;

@Repository
public interface AccidentRepository extends CrudRepository<Accident, Integer> {

}
