package com.example.project.dao;

import com.example.project.entity.TrainingType;
import com.example.project.entity.User;
import com.example.project.service.TrainingTypeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
class TrainingTypeDAOTest {
    @Mock
    private TrainingTypeDAO trainingTypeDAO;
    @InjectMocks
    private TrainingTypeService trainingTypeService;
    private TrainingType trainingType;

    @BeforeEach
    public void setUp() {
        trainingTypeDAO = mock(TrainingTypeDAO.class);
        trainingTypeService = new TrainingTypeService(trainingTypeDAO);
        trainingType = TrainingType.builder().trainingTypeName("New sport").build();
    }

    @Test
    void createTrainingType() {
        trainingTypeService.createTrainingType(trainingType);
        assertEquals(trainingType.getTrainingTypeName(), "New sport");
    }

    @Test
    void updateTrainingType() {
        int idToUpdate = 1;
        TrainingType typeToUpdate = new TrainingType();
        typeToUpdate.setId(idToUpdate);
        typeToUpdate.setTrainingTypeName("Swimming");
        trainingTypeService.updateTrainingType(idToUpdate, typeToUpdate);
        assertEquals("Swimming", typeToUpdate.getTrainingTypeName());
    }
}