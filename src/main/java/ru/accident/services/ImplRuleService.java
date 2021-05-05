package ru.accident.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.accident.domain.Rule;
import ru.accident.repositories.jpa.RuleRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
public class ImplRuleService implements RuleService{

    private final RuleRepository ruleRepository;

    @Override
    public Set<Rule> findAll() {
        return new HashSet<>( (ArrayList<Rule>) ruleRepository.findAll());
    }

    @Override
    public Rule findById(int id) {
        return ruleRepository.findById(id).orElseThrow(() -> new RuntimeException("rule is not found"));
    }
}
