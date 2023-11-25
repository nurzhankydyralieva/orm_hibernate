package com.example.project.service;

import com.example.project.dao.TraineeDAO;
import com.example.project.entity.Trainee;
import com.example.project.entity.Trainer;
import com.example.project.entity.Training;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class TraineeService {
    private final TraineeDAO traineeDAO;

    public void createTrainee(Trainee trainee) {
        traineeDAO.createTrainee(trainee);
    }

    public List<Trainee> selectAllTrainees() {
        return traineeDAO.selectAllTrainees();
    }

    public Trainee selectTraineeById(int id) {
        return traineeDAO.selectTraineeById(id);
    }

    public void updateTrainee(int id, Trainee updatedTrainee) {
        traineeDAO.updateTrainee(id, updatedTrainee);
    }

    public Trainee selectTraineeByUserName(String userName) {
        return traineeDAO.selectTraineeByUserName(userName);
    }

    public void updatePassword(int id, String password) {
        traineeDAO.updatePassword(id, password);
    }

    public void activateTrainee(int id) {
        traineeDAO.activateTrainee(id);
    }

    public void deactivateTrainee(int id) {
        traineeDAO.deactivateTrainee(id);
    }

    public Trainee selectUserNameAndPassword(String userName, String password) {
        return traineeDAO.selectUserNameAndPassword(userName, password);
    }

    public void deleteTraineeByUserName(String userName) {
        traineeDAO.deleteTraineeByUserName(userName);
    }

    public List<Training> selectTraineeTrainingListByTraineeUserNameAndCriteria(String userName, String criteria) {
        return traineeDAO.getTraineeTrainingListByTraineeUserNameAndCriteria(userName, criteria);
    }

    public void deleteTrainee(int id) {
        traineeDAO.deleteTrainee(id);
    }

    public void updateTraineeTrainerList(int updateTraineeId, Set<Trainer> trainers) {
        traineeDAO.updateTraineeTrainerList(updateTraineeId, trainers);
    }
}
