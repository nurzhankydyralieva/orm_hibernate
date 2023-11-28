package com.example.project.service.impl;

import com.example.project.dao.TrainingDAO;
import com.example.project.entity.Training;
import com.example.project.service.TrainingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TrainingServiceImpl implements TrainingService {
    private final TrainingDAO trainingDAO;

    @Override
    public void createTraining(Training training) {
        trainingDAO.createTraining(training);
    }

    @Override
    public List<Training> selectAllTrainings() {
        return trainingDAO.selectAllTrainings();
    }

    @Override
    public Training selectTrainingById(int id) {
        return trainingDAO.showTraining(id);
    }

    @Override
    public void updateTraining(int id, Training updatedTraining) {
        trainingDAO.updateTraining(id, updatedTraining);
    }
}
