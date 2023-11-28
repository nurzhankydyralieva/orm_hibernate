package com.example.project.service.impl;

import com.example.project.dao.TrainingTypeDAO;
import com.example.project.entity.TrainingType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TrainingTypeService {
    private final TrainingTypeDAO trainingTypeDAO;

    public void createTrainingType(TrainingType trainingType) {
        trainingTypeDAO.createTrainingType(trainingType);
    }

    public void updateTrainingType(int id, TrainingType updatedTraining) {
        trainingTypeDAO.updateTrainingType(id, updatedTraining);
    }
}
