package com.example.project.service;

import com.example.project.entity.Training;

import java.util.List;

public interface TrainingService {
     void createTraining(Training training);

     List<Training> selectAllTrainings();

     Training selectTrainingById(int id);

     void updateTraining(int id, Training updatedTraining);
}
