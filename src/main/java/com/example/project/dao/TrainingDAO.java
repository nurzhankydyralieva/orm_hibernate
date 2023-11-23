package com.example.project.dao;

import com.example.project.entity.Training;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@RequiredArgsConstructor
public class TrainingDAO {
    private final SessionFactory sessionFactory;

    @Transactional(readOnly = true)
    public List<Training> selectAllTrainings() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("SELECT t FROM Training t", Training.class).getResultList();
    }

    @Transactional(readOnly = true)
    public Training showTraining(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Training.class, id);
    }

    @Transactional
    public void createTraining(Training training) {
        Session session = sessionFactory.getCurrentSession();
        Training saveTraining = new Training();
        saveTraining.setTrainerId(training.getTrainerId());
        saveTraining.setTraineeId(training.getTraineeId());
        saveTraining.setTrainingName(training.getTrainingName());
        saveTraining.setTrainingTypeId(training.getTrainingTypeId());
        saveTraining.setTrainingDate(training.getTrainingDate());
        Number number = training.getTrainingDuration();
        saveTraining.setTrainingDuration(number);
        session.save(training);
    }

}
