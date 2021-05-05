package ru.accident.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.accident.domain.AccidentType;
import ru.accident.repositories.jpa.AccidentTypeRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
public class ImplAccidentTypeService implements AccidentTypeService{

    private final AccidentTypeRepository accidentTypeRepository;

    @Override
    public Set<AccidentType> findAll() {
        return new HashSet<>( (ArrayList<AccidentType>) accidentTypeRepository.findAll());
    }

    @Override
    public AccidentType findById(int id) {
        return accidentTypeRepository.findById(id).orElseThrow(() -> new RuntimeException("type not found"));
    }
}
