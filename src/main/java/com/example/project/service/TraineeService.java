package com.example.project.service;

import com.example.project.entity.Trainee;
import com.example.project.entity.Trainer;
import com.example.project.entity.Training;

import java.util.List;

public interface TraineeService {
    void createTrainee(Trainee trainee);

    List<Trainee> selectAllTrainees();

    Trainee selectTraineeById(int id);

    void updateTrainee(int id, Trainee updatedTrainee);

    Trainee selectTraineeByUserName(String userName);

    void changePassword(int id, String password);

    void activateTrainee(int id);

    void deactivateTrainee(int id);

    Trainee selectUserNameAndPassword(String userName, String password);

    void deleteTraineeByUserName(String userName);

    List<Training> selectTraineeTrainingListByTraineeUserNameAndCriteria(String userName, String criteria);

    void deleteTrainee(int id);

    void updateTraineeTrainerList(int updateTraineeId, List<Trainer> trainers);

    void selectUserNameAndPasswordMatching(String userNameInput, String passwordInput);
    List<Trainee> selectNotAssignedSpecificTraineeActiveList(int id) ;
}
