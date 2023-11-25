package com.example.project.dao;

import com.example.project.entity.Training;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@RequiredArgsConstructor
public class TrainingDAO {
    private static final Logger LOGGER = LoggerFactory.getLogger(TrainerDAO.class);
    private final SessionFactory sessionFactory;

    @Transactional(readOnly = true)
    public List<Training> selectAllTrainings() {
        Session session = sessionFactory.getCurrentSession();
        LOGGER.info("Training are selected");
        return session.createQuery("SELECT t FROM Training t", Training.class).getResultList();
    }

    @Transactional(readOnly = true)
    public Training showTraining(int id) {
        Session session = sessionFactory.getCurrentSession();
        LOGGER.info("Selected training by id");
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
        LOGGER.info("Training is created");
    }

    @Transactional
    public void updateTraining(int id, Training updatedTraining) {
        Session session = sessionFactory.getCurrentSession();
        Training training = session.get(Training.class, id);
        training.setTrainerId(updatedTraining.getTrainerId());
        training.setTraineeId(updatedTraining.getTraineeId());
        training.setTrainingName(updatedTraining.getTrainingName());
        training.setTrainingDate(updatedTraining.getTrainingDate());
        training.setTrainingDuration(updatedTraining.getTrainingDuration());
        LOGGER.info("Training is updated");
    }
}
