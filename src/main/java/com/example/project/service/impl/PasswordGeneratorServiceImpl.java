package com.example.project.service.impl;

import com.example.project.dao.PasswordGeneratorDAO;
import com.example.project.entity.Trainee;
import com.example.project.entity.Trainer;
import com.example.project.entity.User;
import com.example.project.service.PasswordGeneratorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PasswordGeneratorServiceImpl implements PasswordGeneratorService {
    private final PasswordGeneratorDAO dao;

    @Override
    public List<User> selectAllUsersUserNameAndPassword() {
        return dao.selectAllUsersUserNameAndPassword();
    }

    @Override
    public List<Trainer> selectAllTrainersUserNameAndPassword() {
        return dao.selectAllTrainersUserNameAndPassword();
    }

    @Override
    public List<Trainee> selectAllTraineesUserNameAndPassword() {
        return dao.selectAllTraineesUserNameAndPassword();
    }
}
