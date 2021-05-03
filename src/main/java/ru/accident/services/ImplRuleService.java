package ru.accident.services;

import org.springframework.stereotype.Service;
import ru.accident.domain.Rule;
import ru.accident.repositories.RuleRepository;

import java.util.Set;

@Service
public class ImplRuleService implements RuleService{

    private final RuleRepository ruleRepository;

    public ImplRuleService(RuleRepository ruleRepository) {
        this.ruleRepository = ruleRepository;
    }

    @Override
    public Set<Rule> findAll() {
        return ruleRepository.findAll();
    }

    @Override
    public Rule findById(int id) {
        return ruleRepository.findById(id);
    }
}
