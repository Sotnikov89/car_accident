package ru.accident.services;

import ru.accident.domain.Accident;

import java.util.List;

public interface AccidentService {
    List<Accident> findAll();
    void saveOrUpdate(Accident accident);
    public Accident getById(int id);
}
