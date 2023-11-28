package com.example.project.dao;


import com.example.project.entity.Specialization;
import com.example.project.entity.Trainer;
import com.example.project.entity.User;
import com.example.project.service.impl.TrainerServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
class TrainerDAOTest {
    @Mock
    private TrainerDAO trainerDAO;
    @InjectMocks
    private TrainerServiceImpl trainerService;
    private Trainer trainer;
    public List<Trainer> trainers;

    @BeforeEach
    public void setUp() {
        trainerDAO = mock(TrainerDAO.class);
        trainerService = new TrainerServiceImpl(trainerDAO);
        User user = User.builder().userName("Tom").build();
        trainer = Trainer.builder().user(user).specialization(new Specialization(1)).user(new User(1, "Osman", "Khan", "Sultan", "king", true, "criteria")).build();
        trainers = Arrays.asList(new Trainer(), new Trainer());
    }

    @Test
    void selectAllTrainers() {
        trainerService.selectAllTrainers();
        assertEquals(2, trainers.size());
    }

    @Test
    void createTrainer() {
        trainerService.createTrainer(trainer);
        assertEquals("Osman", trainer.getUser().getFirstName());
    }

    @Test
    void selectTrainerByUserName() {
        trainerService.selectTrainerByUserName("Sultan");
        assertEquals("Sultan", trainer.getUser().getUserName());
    }

    @Test
    void deleteTrainerByUserName() {
        trainerService.deleteTrainerByUserName("Sultan");
        assertNull(trainerService.selectTrainerByUserName("Sultan"));
    }

    @Test
    void updateTrainer() {
        int idToUpdate = 1;
        Trainer trainer1 = new Trainer();
        trainer.setId(idToUpdate);
        trainer.setUser(new User());
        trainerService.updateTrainer(idToUpdate, trainer1);
        assertEquals(new User(), trainer.getUser());
    }

    @Test
    void updatePassword() {
        int id = 1;
        trainer.setUser(User.builder().password("new password").build());
        trainerService.updatePassword(id, "new password");
        assertEquals("new password", trainer.getUser().getPassword());
    }

    @Test
    void activateTrainer() {
        trainerService.activateTrainer(1);
        assertTrue(trainer.getUser().getIsActive());
    }

    @Test
    void deactivateTrainer() {
        trainerService.deactivateTrainer(1);
        assertTrue(trainer.getUser().getIsActive());
    }

    @Test
    void selectUserNameAndPassword() {
        trainerService.selectUserNameAndPassword("Sultan", "king");
        assertEquals("Sultan", trainer.getUser().getUserName());
        assertEquals("king", trainer.getUser().getPassword());
    }

    @Test
    void getTrainerTrainingListByTrainerUserNameAndCriteria() {
        trainerService.selectTrainerTrainingListByTrainerUserNameAndCriteria("Sultan", "criteria");
        assertEquals("Sultan", trainer.getUser().getUserName());
        assertEquals("criteria", trainer.getUser().getCriteria());
    }

    @Test
    void getActiveTrainersList() {
        trainerService.getActiveTrainersList(1);
        assertTrue(trainer.getUser().getIsActive());
    }
}