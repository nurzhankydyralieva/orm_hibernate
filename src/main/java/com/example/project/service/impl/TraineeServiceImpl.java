package com.example.project.service.impl;

import com.example.project.dao.TraineeDAO;
import com.example.project.entity.Trainee;
import com.example.project.entity.Trainer;
import com.example.project.entity.Training;
import com.example.project.service.TraineeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class TraineeServiceImpl implements TraineeService {
    private final TraineeDAO traineeDAO;


    @Override
    public void createTrainee(Trainee trainee) {
        traineeDAO.createTrainee(trainee);
    }

    @Override
    public List<Trainee> selectAllTrainees() {
        return traineeDAO.selectAllTrainees();
    }

    @Override
    public Trainee selectTraineeById(int id) {
        return traineeDAO.selectTraineeById(id);
    }

    @Override
    public void updateTrainee(int id, Trainee updatedTrainee) {
        traineeDAO.updateTrainee(id, updatedTrainee);
    }

    @Override
    public Trainee selectTraineeByUserName(String userName) {
        return traineeDAO.selectTraineeByUserName(userName);
    }

    @Override
    public void changePassword(int id, String password) {
        traineeDAO.changePassword(id, password);
    }


    @Override
    public void activateTrainee(int id) {
        traineeDAO.activateTrainee(id);
    }

    @Override
    public void deactivateTrainee(int id) {
        traineeDAO.deactivateTrainee(id);
    }

    @Override
    public Trainee selectUserNameAndPassword(String userName, String password) {
        return traineeDAO.selectUserNameAndPassword(userName, password);
    }

    @Override
    public void deleteTraineeByUserName(String userName) {
        traineeDAO.deleteTraineeByUserName(userName);
    }

    @Override
    public List<Training> selectTraineeTrainingListByTraineeUserNameAndCriteria(String userName, String criteria) {
        return traineeDAO.getTraineeTrainingListByTraineeUserNameAndCriteria(userName, criteria);
    }

    @Override
    public void deleteTrainee(int id) {
        traineeDAO.deleteTrainee(id);
    }

    @Override
    public void updateTraineeTrainerList(int updateTraineeId, List<Trainer> trainers) {
        traineeDAO.updateTraineeTrainerList(updateTraineeId, trainers);
    }

    @Override
    public void selectUserNameAndPasswordMatching(String userNameInput, String passwordInput) {
        traineeDAO.selectUserNameAndPasswordMatching(userNameInput, passwordInput);
    }
    @Override
    public List<Trainee> selectNotAssignedSpecificTraineeActiveList(int id) {
        return traineeDAO.selectNotAssignedSpecificTraineeActiveList(id);
    }
}
