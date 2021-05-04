package ru.accident.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.accident.domain.AccidentType;
import ru.accident.repositories.jdbc.AccidentTypeJdbc;
import ru.accident.repositories.mem.AccidentTypeMem;

import java.util.Set;

@Service
@AllArgsConstructor
public class ImplAccidentTypeService implements AccidentTypeService{

    private final AccidentTypeJdbc accidentTypeRepository;

    @Override
    public Set<AccidentType> findAll() {
        return accidentTypeRepository.findAll();
    }

    @Override
    public AccidentType findById(int id) {
        return accidentTypeRepository.findById(id);
    }
}
