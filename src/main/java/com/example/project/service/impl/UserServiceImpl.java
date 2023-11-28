package com.example.project.service.impl;

import com.example.project.dao.UserDAO;
import com.example.project.entity.User;
import com.example.project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserDAO userDAO;

    @Override
    public List<User> selectAllUsers() {
        return userDAO.selectAllUsers();
    }

    @Override
    public void createUser(User user) {
        userDAO.createUser(user);
    }

    @Override
    public User selectUserById(int id) {
        return userDAO.showUserById(id);
    }

    @Override
    public void updateUser(int id, User updatedUser) {
        userDAO.updateUser(id, updatedUser);
    }

    @Override
    public boolean deleteUser(int id) {
        userDAO.deleteUser(id);
        return true;
    }
}
