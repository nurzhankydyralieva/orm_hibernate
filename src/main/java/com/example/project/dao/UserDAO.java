package com.example.project.dao;


import com.example.project.entity.User;
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
public class UserDAO {
    private static final Logger LOGGER = LoggerFactory.getLogger(TrainerDAO.class);
    private final SessionFactory sessionFactory;

    @Transactional(readOnly = true)
    public List<User> selectAllUsers() {
        Session session = sessionFactory.getCurrentSession();
        LOGGER.info("Select all users");
        return session.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    @Transactional(readOnly = true)
    public User showUserById(int id) {
        Session session = sessionFactory.getCurrentSession();
        LOGGER.info("Select user by id");
        return session.get(User.class, id);
    }

    @Transactional
    public void createUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
        LOGGER.info("User is created");
    }

    @Transactional
    public void updateUser(int id, User updatedUser) {
        Session session = sessionFactory.getCurrentSession();
        User userToUpdate = session.get(User.class, id);
        userToUpdate.setFirstName(updatedUser.getFirstName());
        userToUpdate.setLastName(updatedUser.getLastName());
        userToUpdate.setUserName(updatedUser.getUserName());
        userToUpdate.setPassword(updatedUser.getPassword());
        userToUpdate.setIsActive(updatedUser.getIsActive());
        LOGGER.info("User is updated");
    }

    @Transactional
    public void deleteUser(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(session.get(User.class, id));
        LOGGER.info("User is deleted");
    }
}
