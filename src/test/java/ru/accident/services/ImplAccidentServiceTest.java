package ru.accident.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ru.accident.domain.Accident;
import ru.accident.domain.AccidentType;
import ru.accident.domain.Rule;
import ru.accident.repositories.jpa.AccidentRepository;
import ru.accident.repositories.jpa.AccidentTypeRepository;
import ru.accident.repositories.jpa.RuleRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

class ImplAccidentServiceTest {

    @Mock
    AccidentTypeRepository accidentTypeRepository;
    @Mock
    AccidentRepository accidentRepository;
    @Mock
    RuleRepository ruleRepository;

    AccidentService accidentService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        accidentService = new ImplAccidentService(accidentRepository, accidentTypeRepository, ruleRepository);
    }

    @Test
    void findAll() {
        Set<Rule> rules = Set.of(
                Rule.builder().id(1).build(),
                Rule.builder().id(2).build());
        List<Accident> accidents = List.of(
                Accident.builder().id(1).name("name1").text("desc1").accidentType(AccidentType.builder().id(1).build()).rules(rules).build(),
                Accident.builder().id(2).name("name2").text("desc2").accidentType(AccidentType.builder().id(2).build()).rules(rules).build());
        when(accidentRepository.findAll()).thenReturn(accidents);
        Set<Accident> returnAccidents = accidentService.findAll();

        assertEquals(returnAccidents.size(), 2);
    }

    @Test
    void findById() {
        Set<Rule> rules = Set.of(
                Rule.builder().id(1).build(),
                Rule.builder().id(2).build());
        Accident accident = Accident.builder().id(3).name("name1").text("desc1").accidentType(AccidentType.builder().id(1).build()).rules(rules).build();
        when(accidentRepository.findById(anyInt())).thenReturn(Optional.ofNullable(accident));
        Accident returnAccident = accidentService.findById(3);

        assertNotNull(returnAccident);
        assertEquals(returnAccident.getId(), 3);
        assertEquals(returnAccident.getName(), "name1");
        assertEquals(returnAccident.getText(), "desc1");
    }

    @Test
    void saveOrUpdate() {
        AccidentType accidentType = AccidentType.builder().id(5).build();
        Rule rule = Rule.builder().id(6).build();
        Accident accident = Accident.builder().id(3).accidentType(accidentType).build();
        when(accidentTypeRepository.findById(anyInt())).thenReturn(Optional.ofNullable(accidentType));
        when(ruleRepository.findById(anyInt())).thenReturn(Optional.ofNullable(rule));
        when(accidentRepository.save(any())).thenReturn(accident);
        accidentService.saveOrUpdate(accident, new String[]{"1"});

        verify(accidentTypeRepository,times(1)).findById(anyInt());
        verify(ruleRepository,times(1)).findById(anyInt());
        verify(accidentRepository,times(1)).save(any());
    }
}