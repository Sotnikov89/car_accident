package ru.accident.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.accident.domain.Accident;
import ru.accident.domain.AccidentType;
import ru.accident.repositories.AccidentRepository;
import ru.accident.repositories.AccidentTypeRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ImplAccidentService implements AccidentService {

    private final AccidentRepository accidentRepository;
    private final AccidentTypeRepository accidentTypeRepository;

    @Override
    public List<Accident> findAll() {
        return accidentRepository.findAll();
    }

    @Override
    public void saveOrUpdate(Accident accident) {
        AccidentType type = accidentTypeRepository.findById(accident.getAccidentType().getId());
        accident.setAccidentType(type);
        accidentRepository.saveOrUpdate(accident);
    }

    @Override
    public Accident getById(int id) {
        return accidentRepository.getById(id);
    }
}
