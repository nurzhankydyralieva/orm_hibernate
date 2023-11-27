package com.example.project.dao;

import com.example.project.entity.TrainingType;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class TrainingTypeDAO {
    private static final Logger LOGGER = LoggerFactory.getLogger(TrainerDAO.class);
    private final SessionFactory sessionFactory;

    @Transactional
    public void createTrainingType(TrainingType trainingType) {
        Session session = sessionFactory.getCurrentSession();
        session.save(trainingType);
        LOGGER.info("Training Type is created");
    }

    @Transactional
    public void updateTrainingType(int id, TrainingType updatedTraining) {
        TrainingType trainingType = new TrainingType();
        trainingType.setTrainingTypeName(updatedTraining.getTrainingTypeName());
        if (updatedTraining.equals(trainingType))
            LOGGER.info("Training type is not allowed to update");
    }
}
