package ru.accident.repositories.hbm;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.accident.domain.Rule;

import java.util.HashSet;
import java.util.Set;

@Repository
@AllArgsConstructor
public class RuleHbm {

    private final HbmMethods hbmMethods;

    public Rule findById(int id) {
        return hbmMethods.sessionMethodsWithReturn(session -> session.get(Rule.class, id));
    }

    public Set<Rule> findAll() {
        return new HashSet<>(hbmMethods.sessionMethodsWithReturn(session -> session.createQuery("from Rule").list()));
    }
}
