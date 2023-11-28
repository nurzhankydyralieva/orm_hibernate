package com.example.project.facade.impl;

import com.example.project.entity.Trainee;
import com.example.project.entity.Trainer;
import com.example.project.entity.Training;
import com.example.project.facade.TraineeFacade;
import com.example.project.service.PasswordGeneratorService;
import com.example.project.service.TraineeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class TraineeFacadeImpl implements TraineeFacade {
    private final TraineeService traineeService;
    private final PasswordGeneratorService passwordGeneratorService;


    @Override
    public void createTrainee(Trainee trainee) {
        traineeService.createTrainee(trainee);
    }

    @Override
    public List<Trainee> selectAllTrainees() {
        return traineeService.selectAllTrainees();
    }

    @Override
    public Trainee selectTraineeById(int id) {
        return traineeService.selectTraineeById(id);
    }

    @Override
    public void updateTrainee(int id, Trainee updatedTrainee) {
        traineeService.updateTrainee(id, updatedTrainee);
    }

    @Override
    public Trainee selectTraineeByUserName(String userName) {
        return traineeService.selectTraineeByUserName(userName);
    }

    @Override
    public void updateTraineePassword(int id, String password) {
        traineeService.changePassword(id, password);
    }

    @Override
    public void activateTrainee(int id) {
        traineeService.activateTrainee(id);
    }

    @Override
    public void deactivateTrainee(int id) {
        traineeService.deactivateTrainee(id);
    }

    @Override
    public void deleteTraineeByUserName(String userName) {
        traineeService.deleteTraineeByUserName(userName);
    }

    @Override
    public void updateTraineeTrainerList(int updateTraineeId, Set<Trainer> trainers) {
        traineeService.updateTraineeTrainerList(updateTraineeId, trainers);
    }

    @Override
    public List<Training> selectTraineeTrainingListByTraineeUserNameAndCriteria(String userName, String criteria) {
        return traineeService.selectTraineeTrainingListByTraineeUserNameAndCriteria(userName, criteria);
    }

    @Override
    public void deleteTrainee(int id) {
        traineeService.deleteTrainee(id);
    }

    @Override
    public Trainee selectUserNameAndPasswordTrainee(String userName, String password) {
        return traineeService.selectUserNameAndPassword(userName, password);
    }

    @Override
    public List<Trainee> traineesUserNameAndPasswordGenerator() {
        return passwordGeneratorService.selectAllTraineesUserNameAndPassword();
    }

    @Override
    public void selectUserNameAndPasswordMatchingTrainee(String userNameInput, String passwordInput) {
        traineeService.selectUserNameAndPasswordMatching(userNameInput, passwordInput);
    }
}
