package com.example.project.service;

import com.example.project.dao.UserDAO;
import com.example.project.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserDAO userDAO;

    public List<User> selectAllUsers() {
        return userDAO.selectAllUsers();
    }

    public void createUser(User user) {
        userDAO.createUser(user);
    }

    public User selectUserById(int id) {
        return userDAO.showUserById(id);
    }

    public void updateUser(int id, User updatedUser) {
        userDAO.updateUser(id, updatedUser);
    }

    public boolean deleteUser(int id) {
        userDAO.deleteUser(id);
        return true;
    }
}
