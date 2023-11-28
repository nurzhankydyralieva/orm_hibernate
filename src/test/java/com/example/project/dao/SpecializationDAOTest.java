package com.example.project.dao;

import com.example.project.entity.Specialization;
import com.example.project.service.impl.SpecializationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
class SpecializationDAOTest {
    @Mock
    private SpecializationDAO specializationDAO;
    @InjectMocks
    private SpecializationService specializationService;
    private Specialization specialization;
    public List<Specialization> specializations;

    @BeforeEach
    public void setUp() {
        specializationDAO = mock(SpecializationDAO.class);
        specializationService = new SpecializationService(specializationDAO);
        specialization = Specialization.builder().speciality("Sports Analytics").build();
        specializations = Arrays.asList(new Specialization(), new Specialization());
    }

    @Test
    void selectAllSpecializations() {
        specializationService.selectAllSpecializations();
        assertEquals(2, specializations.size());
    }

    @Test
    void showSpecializationById() {
        specializationService.getSpecializationById(1);
        assertEquals("Sports Analytics", specialization.getSpeciality());
    }

    @Test
    void createSpecialization() {
        specializationService.createSpecialization(specialization);
        assertEquals(specialization.getSpeciality(), "Sports Analytics");
    }

    @Test
    void updateSpecialization() {
        int idToUpdate = 1;
        Specialization specialization1 = new Specialization();
        specialization.setId(idToUpdate);
        specialization.setSpeciality("This is new specialization");
        specializationService.updateSpecialization(idToUpdate, specialization1);
        assertEquals(2, specializations.size());
        assertEquals("This is new specialization", specialization.getSpeciality());
    }
}