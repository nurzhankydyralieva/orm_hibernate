package com.example.project.dao;

import com.example.project.entity.Trainee;
import com.example.project.entity.Trainer;
import com.example.project.entity.User;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Component
@RequiredArgsConstructor
public class PasswordGeneratorDAO {
    private static final Logger LOGGER = LoggerFactory.getLogger(PasswordGeneratorDAO.class);
    private final SessionFactory sessionFactory;

    public List<User> selectAllUsersUserNameAndPassword() {
        Session session = sessionFactory.openSession();
        List<User> dataFromUserDb = session.createQuery("FROM User u", User.class).list();
        for (User data : dataFromUserDb) {
            String userName = generateUsername(data);
            String password = generateRandomPassword(10);
            System.out.println("UserName: " + userName + ", Password: " + password);
        }
        LOGGER.info("All users userName and passwords are selected");
        return dataFromUserDb;
    }

    public List<Trainer> selectAllTrainersUserNameAndPassword() {
        Session session = sessionFactory.openSession();
        List<Trainer> dataFromTrainerDB = session.createQuery("FROM Trainer t", Trainer.class).getResultList();
        for (Trainer data : dataFromTrainerDB) {
            String userName = generateTrainerUserName(data);
            String password = generateRandomPassword(10);
            System.out.println("Trainer's userName: " + userName + ", Password: " + password);
        }
        LOGGER.info("All trainers userName and passwords are selected");
        return dataFromTrainerDB;
    }

    public List<Trainee> selectAllTraineesUserNameAndPassword() {
        Session session = sessionFactory.openSession();
        List<Trainee> dataFromTraineeDB = session.createQuery("FROM Trainee t", Trainee.class).getResultList();
        for (Trainee data : dataFromTraineeDB) {
            String username = generateTraineeUserName(data);
            String password = generateRandomPassword(10);
            System.out.println("Trainee's userName: " + username + ", Password: " + password);
        }
        LOGGER.info("All trainees userName and passwords are selected");
        return dataFromTraineeDB;
    }

    private static String generateUsername(User data) {
        return data.getFirstName() + "." + data.getLastName();
    }

    private static String generateTrainerUserName(Trainer data) {
        return data.getUser().getFirstName() + "." + data.getUser().getLastName();
    }

    private static String generateTraineeUserName(Trainee data) {
        return data.getUser().getFirstName() + "." + data.getUser().getLastName();
    }

    private static String generateRandomPassword(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()_-+=<>?";
        Random random = new Random();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            password.append(characters.charAt(index));
        }
        return password.toString();
    }
}
