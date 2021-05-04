package ru.accident.repositories.hbm;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.accident.domain.AccidentType;

import java.util.HashSet;
import java.util.Set;

@Repository
@AllArgsConstructor
public class AccidentTypeHbm {

    private final HbmMethods hbmMethods;

    public AccidentType findById(int id) {
        return hbmMethods.sessionMethodsWithReturn(session -> session.get(AccidentType.class, id));
    }

    public Set<AccidentType> findAll() {
        return new HashSet<>(hbmMethods.sessionMethodsWithReturn(session -> session.createQuery("from AccidentType").list()));
    }
}
