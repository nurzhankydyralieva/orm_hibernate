package com.example.project.service.impl;

import com.example.project.dao.TrainerDAO;
import com.example.project.entity.Trainer;
import com.example.project.entity.Training;
import com.example.project.service.TrainerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TrainerServiceImpl implements TrainerService {
    private final TrainerDAO trainerDAO;

    @Override
    public void createTrainer(Trainer trainer) {
        trainerDAO.createTrainer(trainer);
    }

    @Override
    public List<Trainer> selectAllTrainers() {
        return trainerDAO.selectAllTrainers();
    }

    @Override
    public Trainer selectTrainerById(int id) {
        return trainerDAO.showTrainer(id);
    }

    @Override
    public void updateTrainer(int id, Trainer updatedTrainer) {
        trainerDAO.updateTrainer(id, updatedTrainer);
    }

    @Override
    public Trainer selectTrainerByUserName(String userName) {
        return trainerDAO.selectTrainerByUserName(userName);
    }

    @Override
    public void deleteTrainerByUserName(String userName) {
        trainerDAO.deleteTrainerByUserName(userName);
    }

    @Override
    public void updatePassword(int id, String password) {
        trainerDAO.updatePassword(id, password);
    }

    @Override
    public void activateTrainer(int id) {
        trainerDAO.activateTrainer(id);
    }

    @Override
    public void deactivateTrainer(int id) {
        trainerDAO.deactivateTrainer(id);
    }

    @Override
    public Trainer selectUserNameAndPassword(String userName, String password) {
        return trainerDAO.selectUserNameAndPassword(userName, password);
    }

    @Override
    public List<Training> selectTrainerTrainingListByTrainerUserNameAndCriteria(String userName, String criteria) {
        return trainerDAO.getTrainerTrainingListByTrainerUserNameAndCriteria(userName, criteria);
    }

    @Override
    public List<Trainer> getActiveTrainersList(int id) {
        return trainerDAO.getActiveTrainersList(id);
    }

//    @Override
//    public void selectUserNameAndPasswordMatching(String userNameInput, String passwordInput) {
//        trainerDAO.selectUserNameAndPasswordMatching(userNameInput, passwordInput);
//    }
}
