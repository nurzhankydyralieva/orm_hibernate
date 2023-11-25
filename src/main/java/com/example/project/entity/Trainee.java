package com.example.project.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "trainee")
public class Trainee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "trainee_id")
    private Integer id;
    @NotEmpty(message = "Date of birth should not be empty")
    @Column(name = "date_of_birth")
    private Date dateOfBirth;
    @NotEmpty(message = "Address should not be empty")
    @Column(name = "address")
    private String address;
    @NotEmpty(message = "User id should not be empty")
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "trainees")
    private Set<Trainer> trainers;
    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "trainee_training",
            joinColumns = @JoinColumn(name = "trainee_id"),
            inverseJoinColumns = @JoinColumn(name = "training_id")
    )
    private List<Training> trainings;

    public Trainee(Integer id) {
        this.id = id;
    }
}
