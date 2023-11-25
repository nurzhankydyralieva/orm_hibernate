package com.example.project.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer id;
    @NotEmpty(message = "User's first name should not be empty")
    @Column(name = "first_name")
    private String firstName;
    @NotEmpty(message = "User's last name should not be empty")
    @Column(name = "last_name")
    private String lastName;
    @NotEmpty(message = "User name should not be empty")
    @Column(name = "user_name")
    private String userName;
    @NotEmpty(message = "User's password should not be empty")
    @Column(name = "password")
    private String password;
    @Column(name = "is_active")
    private boolean isActive;
    @Column(name = "criteria")
    private String criteria;

    public User(Integer id) {
        this.id = id;
    }

}
