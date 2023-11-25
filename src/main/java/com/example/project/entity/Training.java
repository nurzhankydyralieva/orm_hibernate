package com.example.project.entity;

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
    @NotEmpty(message = "Training type should not be empty")
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "training_type_id")
    private Set<TrainingType> trainingTypeId;
    @NotEmpty(message = "Training date should not be empty")
    @Column(name = "training_date")
    private Date trainingDate;
    @NotEmpty(message = "Training duration should not be empty")
    @Column(name = "training_duration")
    private Number trainingDuration;
}
