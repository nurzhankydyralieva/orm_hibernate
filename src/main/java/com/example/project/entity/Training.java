package com.example.project.entity;

import com.example.project.enums.TrainingType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "training")
public class Training {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "training_id")
    private Integer id;
    @NotEmpty(message = "Trainee id should not be empty")
    @ManyToOne
    @JoinColumn(name = "trainee_id")
    private Trainee traineeId;
    @NotEmpty(message = "Trainer id should not be empty")
    @ManyToOne
    @JoinColumn(name = "trainer_id")
    private Trainer trainerId;
    @NotEmpty(message = "Training name should not be empty")
    @Column(name = "training_name")
    private String trainingName;
    @Enumerated(EnumType.STRING)
    @Column(name = "training_type")
    private Set<TrainingType> trainingType;
    @NotEmpty(message = "Training date should not be empty")
    @Column(name = "training_date")
    private Date trainingDate;
    @NotEmpty(message = "Training duration should not be empty")
    @Column(name = "training_duration")
    private Number trainingDuration;
}
