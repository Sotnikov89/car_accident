package ru.accident.services;

import ru.accident.domain.Rule;

import java.util.Set;

public interface RuleService {
    public Set<Rule> findAll();
    public Rule findById(int id);
}
