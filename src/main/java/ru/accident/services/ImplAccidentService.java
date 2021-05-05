package ru.accident.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.accident.domain.Accident;
import ru.accident.domain.AccidentType;
import ru.accident.repositories.jpa.AccidentRepository;
import ru.accident.repositories.jpa.AccidentTypeRepository;
import ru.accident.repositories.jpa.RuleRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
public class ImplAccidentService implements AccidentService {

    private final AccidentRepository accidentRepository;
    private final AccidentTypeRepository accidentTypeRepository;
    private final RuleRepository ruleRepository;

    @Override
    public Set<Accident> findAll() {
        return new HashSet<>( (ArrayList<Accident>)  accidentRepository.findAll());
    }

    @Override
    public Accident findById(int id) { return accidentRepository.findById(id).orElseThrow(() -> new RuntimeException("account is not found")); }

    @Override
    public void saveOrUpdate(Accident accident, String[] rulesId) {
        AccidentType type = accidentTypeRepository.findById(accident.getAccidentType().getId()).orElseThrow(() -> new RuntimeException("type is not found"));
        accident.setAccidentType(type);
        Arrays.stream(rulesId).map(Integer::parseInt)
                .map(id -> ruleRepository.findById(id).orElseThrow(() -> new RuntimeException("rule is not found")))
                .forEach(accident::addRule);
        accidentRepository.save(accident);
    }
}
