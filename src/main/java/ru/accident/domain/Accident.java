package ru.accident.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Accident {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String text;
    private String address;
    @OneToOne (fetch = FetchType.EAGER)
    private AccidentType accidentType;
    @ManyToMany (fetch = FetchType.EAGER)
    private Set<Rule> rules;

    public void addRule(Rule rule) {
        if (rules == null) {
            rules = new HashSet<>();
        }
        rules.add(rule);
    }
}
