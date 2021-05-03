package ru.accident.repositories;

import org.springframework.stereotype.Component;
import ru.accident.domain.Accident;
import ru.accident.domain.AccidentType;

@Component
public class BaseDownLoad {

    private final AccidentRepository accidentRepository;
    private final AccidentTypeRepository accidentTypeRepository;

    public BaseDownLoad(AccidentRepository accidentRepository, AccidentTypeRepository accidentTypeRepository) {
        this.accidentRepository = accidentRepository;
        this.accidentTypeRepository = accidentTypeRepository;

        AccidentType type1 = AccidentType.builder().id(1).name("Две машины").build();
        accidentTypeRepository.saveOrUpdate(type1);
        AccidentType type2 = AccidentType.builder().id(2).name("Машина и человек").build();
        accidentTypeRepository.saveOrUpdate(type2);
        AccidentType type3 = AccidentType.builder().id(3).name("Машина и велосипедист").build();
        accidentTypeRepository.saveOrUpdate(type3);

        accidentRepository.saveOrUpdate(Accident.builder().id(1).name("Антон").address("Москва").text("Пересек сплошную").accidentType(type1).build());
        accidentRepository.saveOrUpdate(Accident.builder().id(2).name("Андрей").address("Екатеринбург").text("Парковка в неположенном месте").accidentType(type2).build());
        accidentRepository.saveOrUpdate(Accident.builder().id(3).name("Артем").address("Новосибирск").text("Превышение скорости").accidentType(type3).build());
    }
}
