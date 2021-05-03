package ru.accident.repositories;

import org.springframework.stereotype.Repository;
import ru.accident.domain.Accident;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class AccidentRepository {
    private HashMap<Integer, Accident> accidents = new HashMap();
    private static AtomicInteger ID_Supplier = new AtomicInteger(3);

    public AccidentRepository() {
        accidents.put(1, Accident.builder().id(1).name("Антон").address("Москва").text("Пересек сплошную").build());
        accidents.put(2, Accident.builder().id(2).name("Андрей").address("Екатеринбург").text("Парковка в неположенном месте").build());
        accidents.put(3, Accident.builder().id(3).name("Артем").address("Новосибирск").text("Превышение скорости").build());
    }
    public Map<Integer, Accident> findAll() {
        return accidents;
    }
    public void saveOrUpdate(Accident accident) {
        if (accident.getId()==0) {
            accident.setId(ID_Supplier.incrementAndGet());
        }
        accidents.put(accident.getId(), accident);
    }

    public Accident getById(int id) {
        return accidents.get(id);
    }
}
