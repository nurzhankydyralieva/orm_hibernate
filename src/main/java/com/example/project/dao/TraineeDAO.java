package com.example.project.dao;

import com.example.project.entity.Trainee;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@RequiredArgsConstructor
public class TraineeDAO {
    private final SessionFactory sessionFactory;

    @Transactional(readOnly = true)
    public List<Trainee> selectAllTrainees() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("SELECT t FROM Trainee t", Trainee.class).getResultList();
    }

    @Transactional
    public Trainee selectTraineeByUserName(String userName) {
        Session session = sessionFactory.getCurrentSession();
        String query = "SELECT t FROM Trainee t WHERE t.user.userName =:userName";
        Query<Trainee> sessionQuery = session.createQuery(query, Trainee.class);
        sessionQuery.setParameter("userName", userName);
        return sessionQuery.getSingleResult();
    }

    @Transactional(readOnly = true)
    public Trainee selectTraineeById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Trainee.class, id);
    }

    @Transactional
    public void createTrainee(Trainee trainee) {
        Session session = sessionFactory.getCurrentSession();
        Trainee newTrainee = new Trainee();
        newTrainee.setAddress(trainee.getAddress());
        newTrainee.setDateOfBirth(trainee.getDateOfBirth());
        newTrainee.setUser(trainee.getUser());
        session.save(newTrainee);
    }

    @Transactional
    public void updateTrainee(int id, Trainee updatedTrainee) {
        Session session = sessionFactory.getCurrentSession();
        Trainee trainee = session.get(Trainee.class, id);
        trainee.setAddress(updatedTrainee.getAddress());
        trainee.setDateOfBirth(updatedTrainee.getDateOfBirth());
        trainee.setUser(updatedTrainee.getUser());
    }

    @Transactional
    public void updatePassword(int id, String password) {
        Session session = sessionFactory.getCurrentSession();
        String query = "UPDATE User u SET u.password=:password WHERE u.id =(SELECT t.user.id FROM Trainee t WHERE t.user.id =:id)";
        Query updatedPassword = session.createQuery(query);
        updatedPassword.setParameter("id", id);
        updatedPassword.setParameter("password", password);
        updatedPassword.executeUpdate();
    }

    @Transactional
    public void activateTrainee(int id) {
        Session session = sessionFactory.getCurrentSession();
        String query = "UPDATE User u SET u.isActive = true WHERE u.id =(SELECT t.user.id FROM Trainee t WHERE t.user.id =:id)";
        Query activated = session.createQuery(query);
        activated.setParameter("id", id);
        activated.executeUpdate();
    }
    @Transactional
    public void deactivateTrainee(int id) {
        Session session = sessionFactory.getCurrentSession();
        String query = "UPDATE User u SET u.isActive = false WHERE u.id =(SELECT t.user.id FROM Trainee t WHERE t.user.id =:id)";
        Query activated = session.createQuery(query);
        activated.setParameter("id", id);
        activated.executeUpdate();
    }

}
