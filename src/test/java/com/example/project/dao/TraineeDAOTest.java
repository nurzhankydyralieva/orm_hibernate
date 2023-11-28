package com.example.project.dao;

import com.example.project.entity.Trainee;
import com.example.project.entity.User;
import com.example.project.service.impl.TraineeServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
class TraineeDAOTest {
    @Mock
    private TraineeDAO traineeDAO;
    @InjectMocks
    private TraineeServiceImpl traineeService;
    private Trainee trainee;
    public List<Trainee> trainees;

    @BeforeEach
    public void setUp() {
        traineeDAO = mock(TraineeDAO.class);
        traineeService = new TraineeServiceImpl(traineeDAO);
        trainee = Trainee.builder().dateOfBirth(new Date()).address("Kyrgyzstan").user(new User(1, "firstName", "lastName", "userName", "password", true, "criteria")).build();
        trainees = Arrays.asList(new Trainee(), new Trainee());
    }

    @Test
    void selectAllTrainees() {
        traineeService.selectAllTrainees();
        assertEquals(2, trainees.size());
    }

    @Test
    void selectTraineeByUserName() {
        traineeService.selectTraineeByUserName("userName");
        assertEquals("userName", trainee.getUser().getUserName());
    }

    @Test
    void selectTraineeById() {
        traineeService.selectTraineeById(1);
        assertEquals("firstName", trainee.getUser().getFirstName());
    }

    @Test
    void createTrainee() {
        traineeService.createTrainee(trainee);
        assertEquals("Kyrgyzstan", trainee.getAddress());
    }

    @Test
    void updateTrainee() {
        int idToUpdate = 1;
        Trainee trainee1 = new Trainee();
        trainee.setId(idToUpdate);
        trainee.setAddress("Dubai");
        traineeService.updateTrainee(1, trainee1);
        assertEquals("Dubai", trainee.getAddress());
    }

    @Test
    void updatePassword() {
        int idToUpdate = 1;
        trainee.setUser(User.builder().password("newPassword").build());
        traineeService.changePassword(idToUpdate, "newPassword");
        assertEquals("newPassword", trainee.getUser().getPassword());
    }

    @Test
    void activateTrainee() {
        int traineeId = 1;
        traineeService.activateTrainee(traineeId);
        assertTrue(trainee.getUser().isActive());
    }

    @Test
    void deactivateTrainee() {
        int traineeId = 1;
        traineeService.deactivateTrainee(traineeId);
        assertTrue(trainee.getUser().isActive());
    }

    @Test
    void selectUserNameAndPassword() {
        traineeService.selectUserNameAndPassword("userName", "password");
        assertEquals("userName", trainee.getUser().getUserName());
        assertEquals("password", trainee.getUser().getPassword());
    }

    @Test
    void deleteTraineeByUserName() {
        traineeService.deleteTraineeByUserName("userName");
        assertNull(traineeService.selectTraineeByUserName("userName"));
    }

    @Test
    void deleteTrainee() {
        traineeService.deleteTrainee(1);
        assertNull(traineeService.selectTraineeById(1));
    }
}