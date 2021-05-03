package ru.accident.services;

import ru.accident.domain.Accident;

import java.util.Map;

public interface AccidentService {
    Map<Integer, Accident> findAll();
    void saveOrUpdate(Accident accident);
    public Accident getById(int id);
}
