package com.example.project.enums;

public enum TrainingType {

    CONTINUOUS_TRAINING,
    CIRCUIT_TRAINING,
    INTERVAL_TRAINING,
    FLEXIBILITY_TRAINING,
    WEIGHT_TRAINING;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
