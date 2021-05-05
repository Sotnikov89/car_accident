package ru.accident.repositories.jdbc;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.accident.domain.Rule;

import java.util.HashSet;
import java.util.Set;

@Repository
@AllArgsConstructor
public class RuleJdbc {

    private final JdbcTemplate jdbc;

    public Rule findById(int id) {
        return jdbc.queryForObject("SELECT * FROM rule WHERE id = ?", (res, row) -> Rule.builder()
                .id(res.getInt("id"))
                .name(res.getString("name"))
                .build(), id);
    }

    public Set<Rule> findAll() {
        return new HashSet<>(jdbc.query("SELECT * FROM rule", (res, row) -> Rule.builder()
                .id(res.getInt("id"))
                .name(res.getString("name"))
                .build()));
    }
}
