package com.example.project.facade;

import com.example.project.entity.User;

import java.util.List;

public interface UserFacade {
    List<User> usersUserNameAndPasswordGenerator();

    void createUser(User user);

    List<User> selectAllUsers();

    User selectUserById(int id);

    void updateUser(int id, User updatedUser);
}
