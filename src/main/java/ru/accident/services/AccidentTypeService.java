package ru.accident.services;

import ru.accident.domain.AccidentType;

import java.util.Set;

public interface AccidentTypeService {
    Set<AccidentType> findAll();
    AccidentType findById(int id);
}
