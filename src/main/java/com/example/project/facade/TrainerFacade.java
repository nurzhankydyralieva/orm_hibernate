package com.example.project.facade;

import com.example.project.entity.Trainer;
import com.example.project.entity.Training;

import java.util.List;
import java.util.Set;

public interface TrainerFacade {
    void createTrainer(Trainer trainer);

    List<Trainer> selectAllTrainers();

    Trainer selectTrainerById(int id);

    void deleteTrainerByUserName(String userName);

    void updateTrainer(int id, Trainer updatedTrainer);

    Trainer selectTrainerByUserName(String userName);

    void updateTrainerPassword(int id, String password);

    void activateTrainer(int id);

    void deactivateTrainer(int id);

    List<Trainer> selectActiveTrainersList(int id);

    Trainer selectUserNameAndPasswordTrainer(String userName, String password);

    List<Training> selectTrainerTrainingListByTrainerUserNameAndCriteria(String userName, String criteria);

    List<Trainer> trainersUserNameAndPasswordGenerator();
 //   void selectUserNameAndPasswordMatchingTrainer(String userNameInput, String passwordInput);
}
