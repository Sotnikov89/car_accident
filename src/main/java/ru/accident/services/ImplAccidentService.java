package ru.accident.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.accident.domain.Accident;
import ru.accident.domain.AccidentType;
import ru.accident.repositories.AccidentRepository;
import ru.accident.repositories.AccidentTypeRepository;
import ru.accident.repositories.RuleRepository;

import java.util.Arrays;
import java.util.Set;

@Service
@AllArgsConstructor
public class ImplAccidentService implements AccidentService {

    private final AccidentRepository accidentRepository;
    private final AccidentTypeRepository accidentTypeRepository;
    private final RuleRepository ruleRepository;

    @Override
    public Set<Accident> findAll() {
        return accidentRepository.findAll();
    }

    @Override
    public void saveOrUpdate(Accident accident, String[] rulesId) {
        AccidentType type = accidentTypeRepository.findById(accident.getAccidentType().getId());
        accident.setAccidentType(type);
        Arrays.stream(rulesId).map(Integer::parseInt).map(ruleRepository::findById).forEach(accident::addRule);
        accidentRepository.saveOrUpdate(accident);
    }

    @Override
    public Accident getById(int id) {
        return accidentRepository.getById(id);
    }
}
