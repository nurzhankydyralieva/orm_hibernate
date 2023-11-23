package com.example.project.service;

import com.example.project.dao.TrainingDAO;
import com.example.project.entity.Training;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TrainingService {
    private final TrainingDAO trainingDAO;

    public void createTraining(Training training) {
        trainingDAO.createTraining(training);
    }

    public List<Training> selectAllTrainings() {
        return trainingDAO.selectAllTrainings();
    }

    public Training selectTrainingById(int id) {
        return trainingDAO.showTraining(id);
    }
}
