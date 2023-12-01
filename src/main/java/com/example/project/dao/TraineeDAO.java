package com.example.project.dao;

import com.example.project.entity.Trainee;
import com.example.project.entity.Trainer;
import com.example.project.entity.Training;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@RequiredArgsConstructor
public class TraineeDAO {
    private static final Logger LOGGER = LoggerFactory.getLogger(TraineeDAO.class);
    private final SessionFactory sessionFactory;

    @Transactional(readOnly = true)
    public List<Trainee> selectAllTrainees() {
        Session session = sessionFactory.getCurrentSession();
        LOGGER.info("All trainees are selected");
        return session.createQuery("SELECT t FROM Trainee t", Trainee.class).getResultList();
    }

    @Transactional
    public Trainee selectTraineeByUserName(String userName) {
        Session session = sessionFactory.getCurrentSession();
        String query = "SELECT t FROM Trainee t WHERE t.user.userName =:userName";
        Query<Trainee> sessionQuery = session.createQuery(query, Trainee.class);
        sessionQuery.setParameter("userName", userName);
        LOGGER.info("Trainee is selected by user name");
        return sessionQuery.getSingleResult();
    }

    @Transactional(readOnly = true)
    public Trainee selectTraineeById(int id) {
        Session session = sessionFactory.getCurrentSession();
        LOGGER.info("Trainee is selected by id");
        return session.get(Trainee.class, id);
    }

    @Transactional
    public void createTrainee(Trainee trainee) {
        Session session = sessionFactory.getCurrentSession();
        session.save(trainee);
        LOGGER.info("Trainee is created");
    }

    @Transactional
    public void updateTrainee(int id, Trainee updatedTrainee) {
        Session session = sessionFactory.getCurrentSession();

        Trainee trainee = session.get(Trainee.class, id);
        trainee.setAddress(updatedTrainee.getAddress());
        trainee.setDateOfBirth(updatedTrainee.getDateOfBirth());
        trainee.setTrainers(updatedTrainee.getTrainers());
        trainee.setUser(updatedTrainee.getUser());
        LOGGER.info("Trainee is updated");
    }

    @Transactional
    public void changePassword(int id, String password) {
        Session session = sessionFactory.getCurrentSession();
        String query = "UPDATE User u SET u.password=:password WHERE u.id =(SELECT t.user.id FROM Trainee t WHERE t.user.id =:id)";
        Query updatedPassword = session.createQuery(query);
        updatedPassword.setParameter("id", id);
        updatedPassword.setParameter("password", password);
        updatedPassword.executeUpdate();
        LOGGER.info("Trainee's password is updated");
    }

    @Transactional
    public void activateTrainee(int id) {
        Session session = sessionFactory.getCurrentSession();
        String query = "UPDATE User u SET u.isActive = true WHERE u.id =(SELECT t.user.id FROM Trainee t WHERE t.user.id =:id)";
        Query activated = session.createQuery(query);
        activated.setParameter("id", id);
        activated.executeUpdate();
        LOGGER.info("Trainee is activated");
    }

    @Transactional
    public void deactivateTrainee(int id) {
        Session session = sessionFactory.getCurrentSession();
        String query = "UPDATE User u SET u.isActive = false WHERE u.id =(SELECT t.user.id FROM Trainee t WHERE t.user.id =:id)";
        Query activated = session.createQuery(query);
        activated.setParameter("id", id);
        activated.executeUpdate();
        LOGGER.info("Trainee is deactivated");
    }

    @Transactional
    public Trainee selectUserNameAndPassword(String userName, String password) {
        Session session = sessionFactory.getCurrentSession();
        String query = "SELECT t FROM Trainee t WHERE t.user.userName =:userName AND t.user.password =:password";
        Query userNameAndPassword = session.createQuery(query);
        userNameAndPassword.setParameter("userName", userName);
        userNameAndPassword.setParameter("password", password);

        Trainee trainee = (Trainee) userNameAndPassword.uniqueResult();

        if (trainee != null) {
            LOGGER.info("Trainee's user name is: " + trainee.getUser().getUserName() + ", and password is: " + trainee.getUser().getPassword());
        }
        return trainee;
    }

    @Transactional
    public void deleteTraineeByUserName(String userName) {
        Session session = sessionFactory.getCurrentSession();
        Trainee trainee = selectTraineeByUserName(userName);

        if (trainee != null) {
            session.remove(trainee);
            LOGGER.info("Trainee is deleted by User Name");
        }
    }

    @Transactional
    public void deleteTrainee(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(session.get(Trainee.class, id));
        LOGGER.info("Trainee is deleted");
    }

    @Transactional
    public List<Training> getTraineeTrainingListByTraineeUserNameAndCriteria(String userName, String criteria) {
        Session session = sessionFactory.getCurrentSession();
        String query = "SELECT t FROM Trainee tr JOIN tr.user u JOIN tr.trainings t WHERE u.userName = :userName AND u.criteria = :criteria";
        LOGGER.info("Get Trainee Training List by Trainee userName and criteria");
        return session.createQuery(query, Training.class)
                .setParameter("userName", userName)
                .setParameter("criteria", criteria)
                .getResultList();
    }

    @Transactional
    public void selectUserNameAndPasswordMatching(String userName, String password) {
        Session session = sessionFactory.getCurrentSession();
        String getUserByUserName = "SELECT t FROM Trainee t WHERE t.user.userName =:userName";

        Trainee trainee =(Trainee) session.createQuery(getUserByUserName).setParameter("userName", userName).uniqueResult();

        if (trainee != null && password.equals(trainee.getUser().getPassword())) {
            LOGGER.info("UserName and Password exists in trainee database");
        } else {
            LOGGER.info("UserName and Password does not exist in trainee database");
        }
    }

    @Transactional
    public void updateTraineeTrainerList(Integer id, List<Trainer> trainers) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Trainee trainee = session.get(Trainee.class, id);

        if (trainee != null) {
            trainee.setTrainers(trainers);
            session.update(trainers);
        }
        LOGGER.info("Trainee's trainers list is updated");
        transaction.commit();
    }
    @Transactional
    public List<Trainee> selectNotAssignedSpecificTraineeActiveList(int id) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "SELECT t FROM Trainee t JOIN Trainer tr ON t.user.id = tr.id WHERE tr.user.isActive = true AND t.isAssigned = false AND tr.id = :id";
        List<Trainee> result = session.createQuery(hql, Trainee.class)
                .setParameter("id", id)
                .list();
        return result;
    }
}
