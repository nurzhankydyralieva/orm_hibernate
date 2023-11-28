package com.example.project.facade;

import com.example.project.entity.Training;

import java.util.List;

public interface TrainingFacade {
    void createTraining(Training training);

    List<Training> selectAllTrainings();

    Training selectTrainingById(int id);

    void updateTraining(int id, Training updatedTraining);
}
