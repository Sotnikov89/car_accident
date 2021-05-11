package ru.accident.repositories.mem;

import ru.accident.domain.Accident;
import ru.accident.domain.AccidentType;
import ru.accident.domain.Rule;

import java.util.Set;

public class BaseDownLoad {

    private final AccidentMem accidentRepository;
    private final AccidentTypeMem accidentTypeRepository;
    private final RuleMem ruleRepository;

    public BaseDownLoad(AccidentMem accidentRepository, AccidentTypeMem accidentTypeRepository, RuleMem ruleRepository) {
        this.accidentRepository = accidentRepository;
        this.accidentTypeRepository = accidentTypeRepository;
        this.ruleRepository = ruleRepository;

        AccidentType type1 = AccidentType.builder().id(1).name("Две машины").build();
        accidentTypeRepository.saveOrUpdate(type1);
        AccidentType type2 = AccidentType.builder().id(2).name("Машина и человек").build();
        accidentTypeRepository.saveOrUpdate(type2);
        AccidentType type3 = AccidentType.builder().id(3).name("Машина и велосипедист").build();
        accidentTypeRepository.saveOrUpdate(type3);

        Rule rule1 = Rule.builder().id(1).name("Статья 1.").build();
        ruleRepository.saveOrUpdate(rule1);
        Rule rule2 = Rule.builder().id(2).name("Статья 2.").build();
        ruleRepository.saveOrUpdate(rule2);
        Rule rule3 = Rule.builder().id(3).name("Статья 3.").build();
        ruleRepository.saveOrUpdate(rule3);


        accidentRepository.saveOrUpdate(Accident.builder().id(1).name("Антон").address("Москва").text("Пересек сплошную")
                .accidentType(type1)
                .rules(Set.of(rule1))
                .build());
        accidentRepository.saveOrUpdate(Accident.builder().id(2).name("Андрей").address("Екатеринбург").text("Парковка в неположенном месте")
                .accidentType(type2)
                .rules(Set.of(rule3, rule1))
                .build());
        accidentRepository.saveOrUpdate(Accident.builder().id(3).name("Артем").address("Новосибирск").text("Превышение скорости")
                .accidentType(type3)
                .rules(Set.of(rule2))
                .build());
    }
}
