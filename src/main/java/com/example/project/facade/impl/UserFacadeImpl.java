package com.example.project.facade.impl;

import com.example.project.entity.User;
import com.example.project.facade.UserFacade;
import com.example.project.service.PasswordGeneratorService;
import com.example.project.service.UserService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UserFacadeImpl implements UserFacade {
    private final PasswordGeneratorService passwordGeneratorService;
    private final UserService userService;

    @Override
    public List<User> usersUserNameAndPasswordGenerator() {
        return passwordGeneratorService.selectAllUsersUserNameAndPassword();
    }

    @Override
    public void createUser(User user) {
        userService.createUser(user);
    }

    @Override
    public List<User> selectAllUsers() {
        return userService.selectAllUsers();
    }

    @Override
    public User selectUserById(int id) {
        return userService.selectUserById(id);
    }

    @Override
    public void updateUser(int id, User updatedUser) {
        userService.updateUser(id, updatedUser);
    }
}
