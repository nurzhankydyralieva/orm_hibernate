package com.example.project.dao;

import com.example.project.entity.Trainee;
import com.example.project.entity.Trainer;
import com.example.project.entity.Training;
import com.example.project.service.impl.TrainingServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
class TrainingDAOTest {
    @Mock
    private TrainingDAO trainingDAO;
    @InjectMocks
    private TrainingServiceImpl trainingService;
    private Training training;
    public List<Training> trainings;

    @BeforeEach
    public void setUp() {
        trainingDAO = mock(TrainingDAO.class);
        trainingService = new TrainingServiceImpl(trainingDAO);
        training = Training.builder().traineeId(new Trainee(1)).trainerId(new Trainer(1)).trainingName("Dance")
                .trainingDate(new Date()).trainingDuration(2).build();
        trainings = Arrays.asList(new Training(), new Training());
    }


    @Test
    void selectAllTrainings() {
        trainingService.selectAllTrainings();
        assertEquals(2, trainings.size());
    }

    @Test
    void showTraining() {
        trainingService.selectTrainingById(1);
        assertEquals("Dance", training.getTrainingName());
    }

    @Test
    void createTraining() {
        trainingService.createTraining(training);
        assertEquals(training.getTrainingName(), "Dance");
    }

    @Test
    void updateTraining() {
        int idToUpdate = 1;
        Training trainingToUpdate = new Training();
        training.setId(idToUpdate);
        training.setTrainingName("Boxing");
        trainingService.updateTraining(idToUpdate, trainingToUpdate);
        assertEquals(2, trainings.size());
        assertEquals("Boxing", training.getTrainingName());
    }
}