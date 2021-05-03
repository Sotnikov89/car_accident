package ru.accident.services;

import ru.accident.domain.AccidentType;

import java.util.Set;

public interface AccidentTypeService {
    public Set<AccidentType> findAll();
    public AccidentType findById(int id);
}
