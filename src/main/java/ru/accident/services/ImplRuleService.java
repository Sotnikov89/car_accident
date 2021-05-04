package ru.accident.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.accident.domain.Rule;
import ru.accident.repositories.hbm.RuleHbm;
import ru.accident.repositories.jdbc.RuleJdbc;
import ru.accident.repositories.mem.RuleMem;

import java.util.Set;

@Service
@AllArgsConstructor
public class ImplRuleService implements RuleService{

    private final RuleHbm ruleRepository;

    @Override
    public Set<Rule> findAll() {
        return ruleRepository.findAll();
    }

    @Override
    public Rule findById(int id) {
        return ruleRepository.findById(id);
    }
}
