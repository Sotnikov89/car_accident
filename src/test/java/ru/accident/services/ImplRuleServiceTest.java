package ru.accident.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ru.accident.domain.Rule;
import ru.accident.repositories.jpa.RuleRepository;

import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class ImplRuleServiceTest {

    @Mock
    RuleRepository ruleRepository;

    RuleService ruleService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        ruleService = new ImplRuleService(ruleRepository);
    }

    @Test
    void findAll() {
        Rule rule = Rule.builder().id(1).name("rule").build();
        when(ruleRepository.findAll()).thenReturn(Set.of(rule));
        Set<Rule> rules = ruleService.findAll();

        verify(ruleRepository, times(1)).findAll();
        assertEquals(rules.size(), 1);
        assertEquals(rules.contains(rule), true);
    }

    @Test
    void findById() {
        Rule rule = Rule.builder().id(4).name("rule").build();
        when(ruleRepository.findById(anyInt())).thenReturn(Optional.ofNullable(rule));
        Rule returnRule = ruleService.findById(4);

        assertNotNull(returnRule);
        assertEquals(returnRule.getId(), 4);
        assertEquals(returnRule.getName(), "rule");
    }
}