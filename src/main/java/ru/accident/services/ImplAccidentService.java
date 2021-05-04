package ru.accident.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.accident.domain.Accident;
import ru.accident.domain.AccidentType;
import ru.accident.repositories.jdbc.AccidentJdbc;
import ru.accident.repositories.jdbc.AccidentTypeJdbc;
import ru.accident.repositories.jdbc.RuleJdbc;
import ru.accident.repositories.mem.AccidentMem;
import ru.accident.repositories.mem.AccidentTypeMem;
import ru.accident.repositories.mem.RuleMem;

import java.util.Arrays;
import java.util.Set;

@Service
@AllArgsConstructor
public class ImplAccidentService implements AccidentService {

    private final AccidentJdbc accidentRepository;
    private final AccidentTypeJdbc accidentTypeRepository;
    private final RuleJdbc ruleRepository;

    @Override
    public Set<Accident> findAll() {
        return accidentRepository.findAll();
    }

    @Override
    public Accident findById(int id) { return accidentRepository.findById(id); }

    @Override
    public void saveOrUpdate(Accident accident, String[] rulesId) {
        AccidentType type = accidentTypeRepository.findById(accident.getAccidentType().getId());
        accident.setAccidentType(type);
        Arrays.stream(rulesId).map(Integer::parseInt).map(ruleRepository::findById).forEach(accident::addRule);
        accidentRepository.saveOrUpdate(accident);
    }
}
