package ru.accident.repositories.mem;

import ru.accident.domain.Rule;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class RuleMem {

    private final HashMap<Integer, Rule> rules = new HashMap();
    private final static AtomicInteger ID_Supplier = new AtomicInteger(3);

    public RuleMem() {
    }

    public Set<Rule> findAll() {
        return new HashSet<>(rules.values());
    }

    public Rule findById(int id) {
        return rules.get(id);
    }

    public void saveOrUpdate(Rule rule) {
        if (rule.getId() == 0) {
            rule.setId(ID_Supplier.incrementAndGet());
        }
        rules.put(rule.getId(), rule);
    }
}
