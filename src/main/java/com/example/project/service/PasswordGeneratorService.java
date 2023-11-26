package com.example.project.service;

import com.example.project.dao.PasswordGeneratorDAO;
import com.example.project.entity.Trainee;
import com.example.project.entity.Trainer;
import com.example.project.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PasswordGeneratorService {
    private final PasswordGeneratorDAO dao;

    public List<User> selectAllUsersUserNameAndPassword() {
        return dao.selectAllUsersUserNameAndPassword();
    }

    public List<Trainer> selectAllTrainersUserNameAndPassword() {
        return dao.selectAllTrainersUserNameAndPassword();
    }

    public List<Trainee> selectAllTraineesUserNameAndPassword() {
        return dao.selectAllTraineesUserNameAndPassword();
    }
}
