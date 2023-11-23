package com.example.project.dao;

import com.example.project.entity.Trainer;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@RequiredArgsConstructor
public class TrainerDAO {
    private final SessionFactory sessionFactory;

    @Transactional(readOnly = true)
    public List<Trainer> selectAllTrainers() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("SELECT t FROM Trainer t", Trainer.class).getResultList();
    }

    @Transactional
    public Trainer selectTrainerByUserName(String userName) {
        Session session = sessionFactory.getCurrentSession();
        String query = "SELECT t FROM Trainer t WHERE t.user.userName =:userName";
        Query<Trainer> sessionQuery = session.createQuery(query, Trainer.class);
        sessionQuery.setParameter("userName", userName);
        return sessionQuery.getSingleResult();
    }

    @Transactional(readOnly = true)
    public Trainer showTrainer(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Trainer.class, id);
    }

    @Transactional
    public void createTrainer(Trainer trainer) {
        Session session = sessionFactory.getCurrentSession();
        Trainer saveTrainer = new Trainer();
        saveTrainer.setSpecialization(trainer.getSpecialization());
        saveTrainer.setUser(trainer.getUser());
        session.save(trainer);
    }

    @Transactional
    public void updateTrainer(int id, Trainer updatedTrainer) {
        Session session = sessionFactory.getCurrentSession();
        Trainer trainer = session.get(Trainer.class, id);
        trainer.setUser(updatedTrainer.getUser());
        trainer.setSpecialization(updatedTrainer.getSpecialization());
    }

}
