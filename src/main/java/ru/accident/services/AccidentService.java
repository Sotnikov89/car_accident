package ru.accident.services;

import ru.accident.domain.Accident;

import java.util.Set;

public interface AccidentService {
    Set<Accident> findAll();
    void saveOrUpdate(Accident accident, String[] rulesId);
    public Accident getById(int id);
}
