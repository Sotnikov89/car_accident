package ru.accident.repositories.hbm;

import ru.accident.domain.Rule;

import java.util.HashSet;
import java.util.Set;

public class RuleHbm {

    private final HbmMethods hbmMethods;

    public RuleHbm(HbmMethods hbmMethods) {
        this.hbmMethods = hbmMethods;
    }

    public Rule findById(int id) {
        return hbmMethods.sessionMethodsWithReturn(session -> session.get(Rule.class, id));
    }

    public Set<Rule> findAll() {
        return new HashSet<>(hbmMethods.sessionMethodsWithReturn(session -> session.createQuery("from Rule").list()));
    }
}
