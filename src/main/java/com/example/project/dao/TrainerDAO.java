package com.example.project.dao;

import com.example.project.entity.Trainer;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@RequiredArgsConstructor
public class TrainerDAO {
    private static final Logger LOGGER = LoggerFactory.getLogger(TrainerDAO.class);
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
        Query<Trainer> selectedUserName = session.createQuery(query, Trainer.class);
        selectedUserName.setParameter("userName", userName);
        return selectedUserName.getSingleResult();
    }

    @Transactional
    public void deleteTrainerByUserName(String userName) {
        Session session = sessionFactory.getCurrentSession();
        Trainer trainer = selectTrainerByUserName(userName);

        if (trainer != null) {
            session.remove(trainer);
            LOGGER.info("Trainer deleted by User Name");
        }
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

    @Transactional
    public void updatePassword(int id, String password) {
        Session session = sessionFactory.getCurrentSession();
        String query = "update User u set u.password=:password where u.id =(select t.user.id from Trainer t where t.user.id =:id)";
        Query updatedPassword = session.createQuery(query);
        updatedPassword.setParameter("id", id);
        updatedPassword.setParameter("password", password);
        updatedPassword.executeUpdate();
    }
    @Transactional
    public void activateTrainer(int id) {
        Session session = sessionFactory.getCurrentSession();
        String query = "UPDATE User u SET u.isActive = true WHERE u.id =(SELECT t.user.id FROM Trainer t WHERE t.user.id =:id)";
        Query activated = session.createQuery(query);
        activated.setParameter("id", id);
        activated.executeUpdate();
    }
    @Transactional
    public void deactivateTrainer(int id) {
        Session session = sessionFactory.getCurrentSession();
        String query = "UPDATE User u SET u.isActive = false WHERE u.id =(SELECT t.user.id FROM Trainer t WHERE t.user.id =:id)";
        Query activated = session.createQuery(query);
        activated.setParameter("id", id);
        activated.executeUpdate();
    }
}
