package ru.accident.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.accident.domain.AccidentType;
import ru.accident.repositories.AccidentTypeRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ImplAccidentTypeService implements AccidentTypeService{

    private final AccidentTypeRepository accidentTypeRepository;

    @Override
    public List<AccidentType> findAll() {
        return accidentTypeRepository.findAll();
    }

    @Override
    public AccidentType findById(int id) {
        return accidentTypeRepository.findById(id);
    }
}
