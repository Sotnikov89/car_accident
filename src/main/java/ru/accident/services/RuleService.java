package ru.accident.services;

import ru.accident.domain.Rule;

import java.util.Set;

public interface RuleService {
    Set<Rule> findAll();
    Rule findById(int id);
}
