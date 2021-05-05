package ru.accident.repositories.hbm;

import ru.accident.domain.Accident;

import java.util.HashSet;
import java.util.Set;

public class AccidentHbm {

    private final HbmMethods hbmMethods;

    public AccidentHbm(HbmMethods hbmMethods) {
        this.hbmMethods = hbmMethods;
    }

    public Accident findById(int id) {
        return (Accident) hbmMethods.sessionMethodsWithReturn(session -> session.createQuery(
                "select accident from Accident accident join fetch accident.accidentType accidentType join fetch accident.rules rules where accident.id = :id")
                .setParameter("id", id).uniqueResult());
    }

    public Set<Accident> findAll() {
        return new HashSet<>(hbmMethods.sessionMethodsWithReturn(session -> session.createQuery(
                "select accident from Accident accident join fetch accident.accidentType accidentType join fetch accident.rules rules")
                .list()));
    }

    public void saveOrUpdate(Accident accident) {
        hbmMethods.sessionVoidMethods(session -> session.saveOrUpdate(accident));
    }
}
