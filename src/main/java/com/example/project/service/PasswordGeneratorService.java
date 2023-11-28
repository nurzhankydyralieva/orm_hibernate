package com.example.project.service;

import com.example.project.entity.Trainee;
import com.example.project.entity.Trainer;
import com.example.project.entity.User;

import java.util.List;

public interface PasswordGeneratorService {
    List<User> selectAllUsersUserNameAndPassword();

    List<Trainer> selectAllTrainersUserNameAndPassword();

    List<Trainee> selectAllTraineesUserNameAndPassword();
}
