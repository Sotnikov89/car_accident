package ru.accident.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.accident.domain.Accident;
import ru.accident.repositories.AccidentRepository;

import java.util.Map;

@Service
@AllArgsConstructor
public class ImplAccidentService implements AccidentService{

    private AccidentRepository accidentRepository;

    @Override
    public Map<Integer, Accident> findAll() {
        return accidentRepository.getAllAccidents();
    }
}
