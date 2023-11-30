package com.example.project.service;

import com.example.project.entity.Trainer;
import com.example.project.entity.Training;

import java.util.List;

public interface TrainerService {
    void createTrainer(Trainer trainer);

    List<Trainer> selectAllTrainers();

    Trainer selectTrainerById(int id);

    void updateTrainer(int id, Trainer updatedTrainer);

    Trainer selectTrainerByUserName(String userName);

    void deleteTrainerByUserName(String userName);

    void updatePassword(int id, String password);

    void activateTrainer(int id);

    void deactivateTrainer(int id);

    Trainer selectUserNameAndPassword(String userName, String password);

    List<Training> selectTrainerTrainingListByTrainerUserNameAndCriteria(String userName, String criteria);

    void selectUserNameAndPasswordMatching(String userNameInput, String passwordInput);

}
