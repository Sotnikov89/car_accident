package ru.accident.repositories.jdbc;

import org.springframework.jdbc.core.JdbcTemplate;
import ru.accident.domain.Rule;

import java.util.HashSet;
import java.util.Set;

public class RuleJdbc {

    private final JdbcTemplate jdbc;

    public RuleJdbc(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

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
