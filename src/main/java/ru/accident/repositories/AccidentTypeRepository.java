package ru.accident.repositories;

import org.springframework.stereotype.Repository;
import ru.accident.domain.Accident;
import ru.accident.domain.AccidentType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class AccidentTypeRepository {

    private final HashMap<Integer, AccidentType> accidents = new HashMap();
    private final static AtomicInteger ID_Supplier = new AtomicInteger(3);

    public AccidentTypeRepository() {
    }

    public List<AccidentType> findAll() {
        return new ArrayList<>(accidents.values());
    }

    public AccidentType findById(int id) {
        return accidents.get(id);
    }

    public void saveOrUpdate(AccidentType accidentType) {
        if (accidentType.getId() == 0) {
            accidentType.setId(ID_Supplier.incrementAndGet());
        }
        accidents.put(accidentType.getId(), accidentType);
    }

}
