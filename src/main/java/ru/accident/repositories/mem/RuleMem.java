package ru.accident.repositories.mem;

import org.springframework.stereotype.Repository;
import ru.accident.domain.Rule;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
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
