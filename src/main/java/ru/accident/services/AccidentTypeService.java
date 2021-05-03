package ru.accident.services;

import ru.accident.domain.AccidentType;

import java.util.List;

public interface AccidentTypeService {
    public List<AccidentType> findAll();
    public AccidentType findById(int id);
}
