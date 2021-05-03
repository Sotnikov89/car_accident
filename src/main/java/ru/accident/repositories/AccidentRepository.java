package ru.accident.repositories;

import org.springframework.stereotype.Repository;
import ru.accident.domain.Accident;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class AccidentRepository {

    private final HashMap<Integer, Accident> accidents = new HashMap();
    private final static AtomicInteger ID_Supplier = new AtomicInteger(3);

    public AccidentRepository() {
    }

    public Set<Accident> findAll() {
        return new HashSet<>(accidents.values());
    }

    public void saveOrUpdate(Accident accident) {
        if (accident.getId() == 0) {
            accident.setId(ID_Supplier.incrementAndGet());
        }
        accidents.put(accident.getId(), accident);
    }

    public Accident getById(int id) {
        return accidents.get(id);
    }
}
