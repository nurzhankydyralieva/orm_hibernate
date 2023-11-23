package com.example.project.service;

import com.example.project.dao.TraineeDAO;
import com.example.project.entity.Trainee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class TraineeService {
    private final TraineeDAO traineeDAO;

    public void createTrainee(Trainee trainee) {
        traineeDAO.createTrainee(trainee);
    }

    public List<Trainee> selectAllTrainees() {
        return traineeDAO.selectAllTrainees();
    }

    public Trainee selectTraineeById(int id) {
        return traineeDAO.selectTraineeById(id);
    }

    public void updateTrainee(int id, Trainee updatedTrainee) {
        traineeDAO.updateTrainee(id, updatedTrainee);
    }
    public Trainee selectTraineeByUserName(String userName) {
        return traineeDAO.selectTraineeByUserName(userName);
    }
}
