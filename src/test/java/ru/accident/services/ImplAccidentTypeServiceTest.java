package ru.accident.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ru.accident.domain.AccidentType;
import ru.accident.repositories.jpa.AccidentTypeRepository;

import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class ImplAccidentTypeServiceTest {

    @Mock
    AccidentTypeRepository accidentTypeRepository;

    AccidentTypeService accidentTypeService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        accidentTypeService = new ImplAccidentTypeService(accidentTypeRepository) ;
    }

    @Test
    void findAll() {
        AccidentType accidentType = AccidentType.builder().id(1).name("type").build();
        when(accidentTypeRepository.findAll()).thenReturn(Set.of(accidentType));
        Set<AccidentType> accidentTypes = accidentTypeService.findAll();

        verify(accidentTypeRepository, times(1)).findAll();
        assertEquals(accidentTypes.size(), 1);
        assertEquals(accidentTypes.contains(accidentType), true);
    }

    @Test
    void findById() {
        AccidentType accidentType = AccidentType.builder().id(3).name("type").build();
        when(accidentTypeRepository.findById(anyInt())).thenReturn(Optional.ofNullable(accidentType));

        AccidentType returnAccidentType = accidentTypeService.findById(3);

        assertNotNull(returnAccidentType);
        assertEquals(returnAccidentType.getId(), 3);
        assertEquals(returnAccidentType.getName(), "type");
    }
}