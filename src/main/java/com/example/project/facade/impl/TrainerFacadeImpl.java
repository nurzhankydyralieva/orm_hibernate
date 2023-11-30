package com.example.project.facade.impl;

import com.example.project.entity.Trainer;
import com.example.project.entity.Training;
import com.example.project.facade.TrainerFacade;
import com.example.project.service.PasswordGeneratorService;
import com.example.project.service.TrainerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class TrainerFacadeImpl implements TrainerFacade {
    private final TrainerService trainerService;
    private final PasswordGeneratorService passwordGeneratorService;

    @Override
    public void createTrainer(Trainer trainer) {
        trainerService.createTrainer(trainer);
    }

    @Override
    public List<Trainer> selectAllTrainers() {
        return trainerService.selectAllTrainers();
    }

    @Override
    public Trainer selectTrainerById(int id) {
        return trainerService.selectTrainerById(id);
    }

    @Override
    public void deleteTrainerByUserName(String userName) {
        trainerService.deleteTrainerByUserName(userName);
    }

    @Override
    public void updateTrainer(int id, Trainer updatedTrainer) {
        trainerService.updateTrainer(id, updatedTrainer);
    }

    @Override
    public Trainer selectTrainerByUserName(String userName) {
        return trainerService.selectTrainerByUserName(userName);
    }

    @Override
    public void updateTrainerPassword(int id, String password) {
        trainerService.updatePassword(id, password);
    }

    @Override
    public void activateTrainer(int id) {
        trainerService.activateTrainer(id);
    }

    @Override
    public void deactivateTrainer(int id) {
        trainerService.deactivateTrainer(id);
    }

    @Override
    public Trainer selectUserNameAndPasswordTrainer(String userName, String password) {
        return trainerService.selectUserNameAndPassword(userName, password);
    }

    @Override
    public List<Training> selectTrainerTrainingListByTrainerUserNameAndCriteria(String userName, String criteria) {
        return trainerService.selectTrainerTrainingListByTrainerUserNameAndCriteria(userName, criteria);
    }

    @Override
    public List<Trainer> trainersUserNameAndPasswordGenerator() {
        return passwordGeneratorService.selectAllTrainersUserNameAndPassword();
    }


    @Override
    public void selectUserNameAndPasswordMatchingTrainer(String userNameInput, String passwordInput) {
        trainerService.selectUserNameAndPasswordMatching(userNameInput,passwordInput);
    }

}
