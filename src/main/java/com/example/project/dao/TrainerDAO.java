package com.example.project.dao;

import com.example.project.entity.Trainer;
import com.example.project.entity.Training;
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
        LOGGER.info("Selected all Trainers");
        return session.createQuery("SELECT t FROM Trainer t", Trainer.class).getResultList();
    }

    @Transactional
    public Trainer selectTrainerByUserName(String userName) {
        Session session = sessionFactory.getCurrentSession();
        String query = "SELECT t FROM Trainer t WHERE t.user.userName =:userName";
        Query<Trainer> selectedUserName = session.createQuery(query, Trainer.class);
        selectedUserName.setParameter("userName", userName);
        LOGGER.info("Selected Trainer by user name");
        return selectedUserName.getSingleResult();
    }

    @Transactional
    public void deleteTrainerByUserName(String userName) {
        Session session = sessionFactory.getCurrentSession();
        Trainer trainer = selectTrainerByUserName(userName);

        if (trainer != null) {
            session.remove(trainer);
            LOGGER.info("Trainer is deleted by User Name");
        }
    }

    @Transactional(readOnly = true)
    public Trainer showTrainer(int id) {
        Session session = sessionFactory.getCurrentSession();
        LOGGER.info("Selected Trainer by id");
        return session.get(Trainer.class, id);
    }

    @Transactional
    public void createTrainer(Trainer trainer) {
        Session session = sessionFactory.getCurrentSession();
        session.save(trainer);
        LOGGER.info("Trainer is created");
    }

    @Transactional
    public void updateTrainer(int id, Trainer updatedTrainer) {
        Session session = sessionFactory.getCurrentSession();
        Trainer trainer = session.get(Trainer.class, id);
        trainer.setUser(updatedTrainer.getUser());
        trainer.setSpecialization(updatedTrainer.getSpecialization());
        LOGGER.info("Trainer is updated");
    }

    @Transactional
    public void updatePassword(int id, String password) {
        Session session = sessionFactory.getCurrentSession();
        String query = "update User u set u.password=:password where u.id =(select t.user.id from Trainer t where t.user.id =:id)";
        Query updatedPassword = session.createQuery(query);
        updatedPassword.setParameter("id", id);
        updatedPassword.setParameter("password", password);
        updatedPassword.executeUpdate();
        LOGGER.info("Trainer's password is updated");
    }

    @Transactional
    public void activateTrainer(int id) {
        Session session = sessionFactory.getCurrentSession();
        String query = "UPDATE User u SET u.isActive = true WHERE u.id =(SELECT t.user.id FROM Trainer t WHERE t.user.id =:id)";
        Query activated = session.createQuery(query);
        activated.setParameter("id", id);
        activated.executeUpdate();
        LOGGER.info("Trainer is activated");
    }

    @Transactional
    public void deactivateTrainer(int id) {
        Session session = sessionFactory.getCurrentSession();
        String query = "UPDATE User u SET u.isActive = false WHERE u.id =(SELECT t.user.id FROM Trainer t WHERE t.user.id =:id)";
        Query activated = session.createQuery(query);
        activated.setParameter("id", id);
        activated.executeUpdate();
        LOGGER.info("Trainer is deactivated");
    }

    @Transactional
    public Trainer selectUserNameAndPassword(String userName, String password) {
        Session session = sessionFactory.getCurrentSession();
        String query = "SELECT t FROM Trainer t WHERE t.user.userName =:userName AND t.user.password =:password";
        Query userNameAndPassword = session.createQuery(query);
        userNameAndPassword.setParameter("userName", userName);
        userNameAndPassword.setParameter("password", password);

        Trainer trainer = (Trainer) userNameAndPassword.uniqueResult();

        if (trainer != null) {
            LOGGER.info("Trainer's user name is: " + trainer.getUser().getUserName() + ", and password is: " + trainer.getUser().getPassword());
        }
        return trainer;
    }

    @Transactional
    public List<Training> getTrainerTrainingListByTrainerUserNameAndCriteria(String userName, String criteria) {
        Session session = sessionFactory.getCurrentSession();
        String query = "SELECT t FROM Trainer tr JOIN tr.user u JOIN tr.trainings t WHERE u.userName = :userName AND u.criteria = :criteria";

        LOGGER.info("Get Trainer Training List by Trainer userName and criteria");
        return session.createQuery(query, Training.class)
                .setParameter("userName", userName)
                .setParameter("criteria", criteria)
                .getResultList();
    }

    @Transactional
    public void selectUserNameAndPasswordMatching(String userNameInput, String passwordInput) {
        Session session = sessionFactory.getCurrentSession();
        String userNameQuery = "SELECT t FROM Trainer t WHERE t.user.userName =:userNameInput";
        String passwordInDB = "SELECT t FROM Trainer t WHERE  t.user.password =:passwordInput";

        Object resultUserName = session.createQuery(userNameQuery).setParameter("userNameInput", userNameInput).uniqueResult();
        Object resultPassword = session.createQuery(passwordInDB).setParameter("passwordInput", passwordInput).uniqueResult();
        if (resultUserName != null && resultPassword != null) {
            LOGGER.info("UserName and Password exists in trainee database");
        } else {
            LOGGER.info("UserName and Password does not exist in trainee database");
        }
    }
}
