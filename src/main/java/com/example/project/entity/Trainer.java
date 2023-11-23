package com.example.project.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "trainer")
public class Trainer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "trainer_id")
    private Integer id;
    @OneToOne
    @JoinColumn(name = "specialization_id")
    private Specialization specialization;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Trainer(Integer id) {
        this.id = id;
    }
}
