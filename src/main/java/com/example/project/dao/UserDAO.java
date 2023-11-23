package com.example.project.dao;


import com.example.project.entity.User;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UserDAO {
    private final SessionFactory sessionFactory;

    @Transactional(readOnly = true)
    public List<User> selectAllUsers() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    @Transactional(readOnly = true)
    public User showUserById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(User.class, id);
    }

    @Transactional
    public void createUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
    }

    @Transactional
    public void updateUser(int id, User updatedUser) {
        Session session = sessionFactory.getCurrentSession();
        User userToUpdate = session.get(User.class, id);
        userToUpdate.setFirstName(updatedUser.getFirstName());
        userToUpdate.setLastName(updatedUser.getLastName());
        userToUpdate.setUserName(updatedUser.getUserName());
        userToUpdate.setPassword(updatedUser.getPassword());
        userToUpdate.setActive(updatedUser.isActive());
    }

    @Transactional
    public void deleteUser(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(session.get(User.class, id));
    }
}
