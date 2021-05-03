package ru.accident.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.accident.domain.Accident;
import ru.accident.repositories.AccidentRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ImplAccidentService implements AccidentService{

    private final AccidentRepository accidentRepository;

    @Override
    public List<Accident> findAll() {
        return accidentRepository.findAll();
    }

    @Override
    public void saveOrUpdate(Accident accident) {
        accidentRepository.saveOrUpdate(accident);
    }

    @Override
    public Accident getById(int id) {
        return accidentRepository.getById(id);
    }
}
