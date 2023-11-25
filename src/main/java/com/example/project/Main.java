package com.example.project;

import com.example.project.config.SpringConfig;
import com.example.project.entity.*;
import com.example.project.facade.ServiceFacade;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        ServiceFacade facade = context.getBean(ServiceFacade.class);

        var user = User.builder().firstName("Maxim").lastName("Smith").userName("Toms").password("333").isActive(true).criteria("Criteria for Selecting Training Modalities").build();
        var updatedUser = User.builder().firstName("Katy").lastName("Simson").userName("Moon").password("123").isActive(true).build();
        //facade.createUser(user);
        //facade.selectAllUsers().stream().forEach(System.out::println);
        //System.out.println(facade.selectUserById(1));

        var specialization = Specialization.builder().speciality("Sports Analytics").build();
        var updatedSpecialization = Specialization.builder().speciality("Technology specializations").build();
        //facade.createSpecialization(specialization);
        //facade.selectAllSpecializations().stream().forEach(System.out::println);
        //System.out.println(facade.selectSpecializationById(1));
        //facade.updateSpecialization(1, updatedSpecialization);

        var trainer = Trainer.builder().specialization(new Specialization(1)).user(new User(1)).build();
        var updatedTrainer = Trainer.builder().specialization(new Specialization(2)).user(new User(3)).build();
        //facade.createTrainer(trainer);
        //  facade.selectAllTrainers();
        // facade.selectTrainerById(1);
        //  facade.updateTrainer(1, updatedTrainer);
        // System.out.println(facade.selectTrainerByUserName("Tom"));
        //facade.deleteTrainerByUserName("Tom");
        //facade.updateTrainerPassword(1, "8888");
        //facade.activateTrainer(1);
        //facade.deactivateTrainer(1);
        //facade.selectUserNameAndPasswordTrainer("Tom", "333");
        //facade.selectTrainerTrainingListByTrainerUserNameAndCriteria("Tom", "sport");
        //System.out.println(facade.selectActiveTrainersList(1));


        var training = Training.builder().traineeId(new Trainee(1)).trainerId(new Trainer(1)).trainingName("Dance")
                .trainingDate(new Date()).trainingDuration(2).build();
        var updatedTraining = Training.builder().traineeId(new Trainee(1)).trainerId(new Trainer(1)).trainingName("Swimming")
                .trainingDate(new Date()).trainingDuration(2).build();
        // facade.createTraining(training);
        //  facade.selectAllTrainings().stream().forEach(System.out::println);
        //  System.out.println(facade.selectTrainingById(1));
        // facade.updateTraining(2, updatedTraining);


        var trainee = Trainee.builder().dateOfBirth(new Date()).address("Kyrgyzstan").user(new User(1)).build();
        var updatedTrainee = Trainee.builder().dateOfBirth(new Date()).address("Mexico").user(new User(3)).build();
        // facade.createTrainee(trainee);
        // facade.selectAllTrainees().stream().forEach(System.out::println);
        // System.out.println(facade.selectTraineeById(2));
        //  facade.updateTrainee(1, updatedTrainee);
        //  System.out.println(facade.selectTraineeByUserName("Katy"));
        // facade.updateTraineePassword(1,"trainee");
        //facade.activateTrainee(1);
        //facade.deactivateTrainee(1);
        // facade.selectUserNameAndPasswordTrainee("Tom","333");
        // facade.deleteTraineeByUserName("Tom");
        // facade.selectTraineeTrainingListByTraineeUserNameAndCriteria("Tom", "sport");
        //facade.deleteTrainee(3);

        var trainingType = TrainingType.builder().trainingTypeName("New sport").build();
        // facade.createTrainingType(trainingType);
        //facade.updateTrainingType(2, trainingType);

        Set<Trainer> trainers = new HashSet<>();
        //trainers.add(Trainer.builder().specialization(new Specialization()).user(new User()).build());
        //facade.updateTraineeTrainerList(4, trainers);

        context.close();
    }
}
