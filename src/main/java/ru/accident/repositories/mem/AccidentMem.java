package ru.accident.repositories.mem;

import ru.accident.domain.Accident;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class AccidentMem {

    private final HashMap<Integer, Accident> accidents = new HashMap();
    private final static AtomicInteger ID_Supplier = new AtomicInteger(3);

    public AccidentMem() {
    }

    public Set<Accident> findAll() {
        return new HashSet<>(accidents.values());
    }

    public Accident findById(int id) {
        return accidents.get(id);
    }

    public void saveOrUpdate(Accident accident) {
        if (accident.getId() == 0) {
            accident.setId(ID_Supplier.incrementAndGet());
        }
        accidents.put(accident.getId(), accident);
    }
}
