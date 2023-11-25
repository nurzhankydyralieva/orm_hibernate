package com.example.project.service;

import com.example.project.dao.TrainerDAO;
import com.example.project.entity.Trainer;
import com.example.project.entity.Training;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TrainerService {
    private final TrainerDAO trainerDAO;

    public void createTrainer(Trainer trainer) {
        trainerDAO.createTrainer(trainer);
    }

    public List<Trainer> selectAllTrainers() {
        return trainerDAO.selectAllTrainers();
    }

    public Trainer selectTrainerById(int id) {
        return trainerDAO.showTrainer(id);
    }

    public void updateTrainer(int id, Trainer updatedTrainer) {
        trainerDAO.updateTrainer(id, updatedTrainer);
    }

    public Trainer selectTrainerByUserName(String userName) {
        return trainerDAO.selectTrainerByUserName(userName);
    }

    public void deleteTrainerByUserName(String userName) {
        trainerDAO.deleteTrainerByUserName(userName);
    }

    public void updatePassword(int id, String password) {
        trainerDAO.updatePassword(id, password);
    }

    public void activateTrainer(int id) {
        trainerDAO.activateTrainer(id);
    }

    public void deactivateTrainer(int id) {
        trainerDAO.deactivateTrainer(id);
    }

    public Trainer selectUserNameAndPassword(String userName, String password) {
        return trainerDAO.selectUserNameAndPassword(userName, password);
    }

    public List<Training> selectTrainerTrainingListByTrainerUserNameAndCriteria(String userName, String criteria) {
        return trainerDAO.getTrainerTrainingListByTrainerUserNameAndCriteria(userName, criteria);
    }

    public List<Trainer> getActiveTrainersList(int id) {
        return trainerDAO.getActiveTrainersList(id);
    }
}
