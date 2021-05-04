package ru.accident.services;

import ru.accident.domain.Accident;

import java.util.Set;

public interface AccidentService {
    Set<Accident> findAll();
    Accident findById(int id);
    void saveOrUpdate(Accident accident, String[] rulesId);
}
