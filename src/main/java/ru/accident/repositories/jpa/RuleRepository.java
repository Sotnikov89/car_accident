package ru.accident.repositories.jpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.accident.domain.Rule;

@Repository
public interface RuleRepository extends CrudRepository<Rule, Integer> {
}
