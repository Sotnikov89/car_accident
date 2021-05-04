package ru.accident.repositories.jdbc;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.accident.domain.AccidentType;

import java.util.HashSet;
import java.util.Set;

@Repository
@AllArgsConstructor
public class AccidentTypeJdbc {

    private final JdbcTemplate jdbc;

    public AccidentType findById(int id) {
        return jdbc.queryForObject("SELECT * FROM accidentType WHERE id = ?", (res, row) -> AccidentType.builder()
                .id(res.getInt("id"))
                .name(res.getString("name"))
                .build(), id);
    }

    public Set<AccidentType> findAll() {
        return new HashSet<>(jdbc.query("SELECT * FROM accidentType", (res, row) -> AccidentType.builder()
                .id(res.getInt("id"))
                .name(res.getString("name"))
                .build()));
    }
}
