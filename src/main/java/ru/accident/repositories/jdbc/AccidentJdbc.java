package ru.accident.repositories.jdbc;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import ru.accident.domain.Accident;
import ru.accident.domain.AccidentType;
import ru.accident.domain.Rule;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.*;
import java.util.stream.Collectors;

@Repository
public class AccidentJdbc {

    private final JdbcTemplate jdbc;

    public AccidentJdbc(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public Accident findById(int id) {
        final int[] typeId = new int[1];
        Accident accident = jdbc.queryForObject("SELECT * FROM accident WHERE id = ?", (res, row) -> {
            typeId[0] = res.getInt("accidentType");
            return Accident.builder()
                    .id(res.getInt("id"))
                    .name(res.getString("name"))
                    .address(res.getString("address"))
                    .text(res.getString("text"))
                    .build();
        }, id);
        accident.setAccidentType(getTypeById(typeId[0]));
        accident.setRules(getRulesByAccidentId(accident.getId()));
        return accident;
    }

    public Set<Accident> findAll() {
        Map<Integer, Integer> accAndtype = new HashMap<>();
        List<Accident> accidents = jdbc.query("SELECT * FROM accident", (res, row) ->{
            accAndtype.put(res.getInt("id"), res.getInt("accidentType"));
            return Accident.builder()
                    .id(res.getInt("id"))
                    .name(res.getString("name"))
                    .address(res.getString("address"))
                    .text(res.getString("text"))
                    .build();
        });
        accidents.forEach(accident -> accident.setAccidentType(getTypeById(accAndtype.get(accident.getId()))));
        accidents.forEach(accident -> accident.setRules(getRulesByAccidentId(accident.getId())));
        return new HashSet<>(accidents);
    }

    public void saveOrUpdate(Accident accident) {
        if (accident.getId() == 0) {
            save(accident);
        } else {
            update(accident);
        }
    }

    private void save(Accident accident) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbc.update(connection -> { PreparedStatement ps = connection
                        .prepareStatement("INSERT INTO accident (name, text, address, accidenttype) VALUES(?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
                    ps.setString(1, accident.getName());
                    ps.setString(2, accident.getText());
                    ps.setString(3, accident.getAddress());
                    ps.setInt(4, accident.getAccidentType().getId());
                    return ps;
        }, keyHolder);
        accident.getRules().forEach(rule -> jdbc.update("INSERT INTO accident_rule (accident_id, rule_id) VALUES(?, ?)", keyHolder.getKeys().get("id"), rule.getId()));
    }

    private void update(Accident accident) {
        jdbc.update("UPDATE accident SET name = ?, text = ?, address = ?, accidenttype = ? WHERE id = ?",
                accident.getName(),
                accident.getText(),
                accident.getAddress(),
                accident.getAccidentType().getId(),
                accident.getId());
        jdbc.update("DELETE FROM accident_rule WHERE accident_id =?", accident.getId());
        accident.getRules().forEach(rule -> jdbc.update("INSERT INTO accident_rule (accident_id, rule_id) VALUES(?, ?)", accident.getId(), rule.getId()));
    }

    private AccidentType getTypeById(int id) {
        return jdbc.queryForObject("SELECT * FROM accidentType WHERE id = ?", (res, row) -> AccidentType.builder()
                .id(res.getInt("id"))
                .name(res.getString("name"))
                .build(), id);
    }

    private Set<Rule> getRulesByAccidentId(int id) {
        List<Integer> ruleIds = jdbc.query("SELECT * FROM accident_rule WHERE accident_id =?", (res, row) -> res.getInt("rule_id"), id);
        return ruleIds.stream().map(integer -> jdbc.queryForObject("SELECT * FROM rule WHERE id = ?", (res, row) -> Rule.builder()
                .id(res.getInt("id"))
                .name(res.getString("name"))
                .build(), integer)).collect(Collectors.toSet());
    }
}
