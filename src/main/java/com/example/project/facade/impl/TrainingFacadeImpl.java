package com.example.project.facade.impl;

import com.example.project.entity.Training;
import com.example.project.facade.TrainingFacade;
import com.example.project.service.TrainingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class TrainingFacadeImpl implements TrainingFacade {
    private final TrainingService trainingService;

    @Override
    public void createTraining(Training training) {
        trainingService.createTraining(training);
    }

    @Override
    public List<Training> selectAllTrainings() {
        return trainingService.selectAllTrainings();
    }

    @Override
    public Training selectTrainingById(int id) {
        return trainingService.selectTrainingById(id);
    }

    @Override
    public void updateTraining(int id, Training updatedTraining) {
        trainingService.updateTraining(id, updatedTraining);
    }
}
