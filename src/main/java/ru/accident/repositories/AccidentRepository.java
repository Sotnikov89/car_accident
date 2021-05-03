package ru.accident.repositories;

import org.springframework.stereotype.Repository;
import ru.accident.domain.Accident;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class AccidentRepository {
    private HashMap<Integer, Accident> accidents = new HashMap();
    private static AtomicInteger ID_Supplier = new AtomicInteger(0);

    public AccidentRepository() {
        accidents.put(1, Accident.builder().id(1).name("Антон").address("Москва").text("Пересек сплошную").build());
        accidents.put(2, Accident.builder().id(2).name("Андрей").address("Екатеринбург").text("Парковка в неположенном месте").build());
        accidents.put(3, Accident.builder().id(3).name("Артем").address("Новосибирск").text("Превышение скорости").build());
    }
    public Map<Integer, Accident> getAllAccidents(){
        return accidents;
    };
}
