package com.example.project;

import com.example.project.config.SpringConfig;
import com.example.project.entity.*;
import com.example.project.enums.TrainingType;
import com.example.project.facade.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserFacade userFacade = context.getBean(UserFacade.class);
        TrainingFacade trainingFacade = context.getBean(TrainingFacade.class);
        TrainerFacade trainerFacade = context.getBean(TrainerFacade.class);
        TraineeFacade traineeFacade = context.getBean(TraineeFacade.class);
        SpecializationFacade specializationFacade = context.getBean(SpecializationFacade.class);

        var user = User.builder().firstName("Maxim").lastName("Bocelli").userName("max").password("999").isActive(true).criteria("Criteria for Selecting Training Modalities").build();
        var updatedUser = User.builder().firstName("Katy").lastName("Simson").userName("Moon").password("123").isActive(true).build();
//         userFacade.createUser(user);
//        userFacade.selectAllUsers().stream().forEach(System.out::println);
//        System.out.println(userFacade.selectUserById(1));
//        userFacade.usersUserNameAndPasswordGenerator();

        var specialization = Specialization.builder().speciality("Concerns Physiologic and Psychological").build();
        var updatedSpecialization = Specialization.builder().speciality("Information technology specializations").build();
//         specializationFacade.createSpecialization(specialization);
//        specializationFacade.selectAllSpecializations().stream().forEach(System.out::println);
//        System.out.println(specializationFacade.selectSpecializationById(1));
//        specializationFacade.updateSpecialization(1, updatedSpecialization);

        var trainer = Trainer.builder().specialization(new Specialization(1)).user(new User(3)).build();
        var updatedTrainer = Trainer.builder().specialization(new Specialization(1)).user(new User(1)).build();
//           trainerFacade.createTrainer(trainer);
//        trainerFacade.selectAllTrainers().stream().forEach(System.out::println);
//        System.out.println(trainerFacade.selectTrainerById(1));
//        trainerFacade.updateTrainer(1, updatedTrainer);
//        System.out.println(trainerFacade.selectTrainerByUserName("Toms"));
//        trainerFacade.deleteTrainerByUserName("Toms");
//        trainerFacade.updateTrainerPassword(2, "8888");
//        trainerFacade.activateTrainer(2);
//        trainerFacade.deactivateTrainer(2);
//        trainerFacade.selectUserNameAndPasswordTrainer("Andy", "8888");
//        trainerFacade.selectTrainerTrainingListByTrainerUserNameAndCriteria("Andy", "Criteria for Selecting Training Modalities");
//         trainerFacade.trainersUserNameAndPasswordGenerator();
//        trainerFacade.selectUserNameAndPasswordMatchingTrainer("new","222");


        Set<TrainingType> types = new HashSet<>();
        types.add(TrainingType.WEIGHT_TRAINING);
        var training = Training.builder().traineeId(new Trainee(1)).trainerId(new Trainer(1)).trainingType(types).trainingName("Gymnastics")
                .trainingDate(new Date()).trainingDuration(2).build();
        var updatedTraining = Training.builder().traineeId(new Trainee(1)).trainerId(new Trainer(1)).trainingType(types).trainingName("Swimming")
                .trainingDate(new Date()).trainingDuration(2).build();
//        trainingFacade.createTraining(training);
//        trainingFacade.selectAllTrainings().stream().forEach(System.out::println);
//        System.out.println(trainingFacade.selectTrainingById(6));
//        trainingFacade.updateTraining(2, updatedTraining);

        List<Trainer> trainerSet = new ArrayList<>();
        trainerSet.add(Trainer.builder().specialization(specialization).user(user).build());
        var trainee = Trainee.builder().dateOfBirth(new Date()).address("Kyrgyzstan, Bishkek 33").user(new User(2)).trainers(trainerSet).isAssigned(false).build();
        var updatedTrainee = Trainee.builder().dateOfBirth(new Date()).address("Mexico").user(new User(3)).trainers(trainerSet).build();
//        traineeFacade.createTrainee(trainee);
//        traineeFacade.selectAllTrainees().stream().forEach(System.out::println);
//         System.out.println(traineeFacade.selectTraineeById(2));
//        traineeFacade.updateTrainee(1, updatedTrainee);
//        System.out.println(traineeFacade.selectTraineeByUserName("Toms"));
//        traineeFacade.updateTraineePassword(2,"trainee");
//        traineeFacade.activateTrainee(2);
//        traineeFacade.deactivateTrainee(2);
//        traineeFacade.selectUserNameAndPasswordTrainee("Toms","333");
//        traineeFacade.deleteTraineeByUserName("Toms");
//        traineeFacade.selectTraineeTrainingListByTraineeUserNameAndCriteria("Andy", "Criteria for Selecting Training Modalities");
//        traineeFacade.deleteTrainee(3);
//        traineeFacade.traineesUserNameAndPasswordGenerator();
//        traineeFacade.selectUserNameAndPasswordMatchingTrainee("Toms","333");
        List<Trainer> trainers = new ArrayList<>();
        trainers.add(trainer);
//        traineeFacade.updateTraineeTrainerList(1, trainers);
//        traineeFacade.selectNotAssignedSpecificTraineeActiveList(2).stream().forEach(System.out::println);
        context.close();
    }
}
