package com.example.project.facade;

import com.example.project.entity.Trainee;
import com.example.project.entity.Trainer;
import com.example.project.entity.Training;

import java.util.List;

public interface TraineeFacade {
    void createTrainee(Trainee trainee);

    List<Trainee> selectAllTrainees();

    Trainee selectTraineeById(int id);

    void updateTrainee(int id, Trainee updatedTrainee);

    Trainee selectTraineeByUserName(String userName);

    void updateTraineePassword(int id, String password);

    void activateTrainee(int id);

    void deactivateTrainee(int id);

    void deleteTraineeByUserName(String userName);

    void updateTraineeTrainerList(int updateTraineeId, List<Trainer> trainers);

    List<Training> selectTraineeTrainingListByTraineeUserNameAndCriteria(String userName, String criteria);

    void deleteTrainee(int id);

    Trainee selectUserNameAndPasswordTrainee(String userName, String password);

    List<Trainee> traineesUserNameAndPasswordGenerator();

    void selectUserNameAndPasswordMatchingTrainee(String userNameInput, String passwordInput);
    List<Trainee> selectNotAssignedSpecificTraineeActiveList(int id) ;

}
