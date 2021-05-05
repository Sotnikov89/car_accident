package ru.accident.repositories.hbm;

import ru.accident.domain.AccidentType;

import java.util.HashSet;
import java.util.Set;

public class AccidentTypeHbm {

    private final HbmMethods hbmMethods;

    public AccidentTypeHbm(HbmMethods hbmMethods) {
        this.hbmMethods = hbmMethods;
    }

    public AccidentType findById(int id) {
        return hbmMethods.sessionMethodsWithReturn(session -> session.get(AccidentType.class, id));
    }

    public Set<AccidentType> findAll() {
        return new HashSet<>(hbmMethods.sessionMethodsWithReturn(session -> session.createQuery("from AccidentType").list()));
    }
}
