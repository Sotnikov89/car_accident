package ru.accident.repositories.mem;

import org.springframework.stereotype.Repository;
import ru.accident.domain.AccidentType;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class AccidentTypeMem {

    private final HashMap<Integer, AccidentType> accidentTypes = new HashMap();
    private final static AtomicInteger ID_Supplier = new AtomicInteger(3);

    public AccidentTypeMem() {
    }

    public Set<AccidentType> findAll() {
        return new HashSet<>(accidentTypes.values());
    }

    public AccidentType findById(int id) {
        return accidentTypes.get(id);
    }

    public void saveOrUpdate(AccidentType accidentType) {
        if (accidentType.getId() == 0) {
            accidentType.setId(ID_Supplier.incrementAndGet());
        }
        accidentTypes.put(accidentType.getId(), accidentType);
    }
}
