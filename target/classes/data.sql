DROP TABLE IF EXISTS users;
CREATE TABLE users
(
    user_id    INTEGER PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
    first_name VARCHAR(128),
    last_name  VARCHAR(128),
    user_name  VARCHAR(128),
    password   VARCHAR(255),
    is_active  BOOLEAN
);

DROP TABLE IF EXISTS trainer;
CREATE TABLE trainer
(
    trainer_id        INTEGER PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
    specialization_id INTEGER,
    user_id           INTEGER
);

CREATE TABLE specialization
(
    specialization_id INTEGER PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
    speciality        VARCHAR(255)
);

CREATE TABLE trainee
(
    trainee_id    INTEGER PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
    date_of_birth DATE,
    address       VARCHAR(255),
    user_id       INTEGER
);
CREATE TABLE training
(
    training_id       INTEGER PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
    trainee_id        INTEGER,
    trainer_id        INTEGER,
    training_name     VARCHAR(255),
    training_type_id  INTEGER,
    training_date     DATE,
    training_duration bytea
);
CREATE TABLE training_type
(
    training_type_id   INTEGER PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
    training_type_name VARCHAR(120)
);


DROP TABLE IF EXISTS users_trainer;
CREATE TABLE users_trainer
(
    trainer_id        INTEGER,
    user_id INTEGER,
    PRIMARY KEY (trainer_id, user_id),
    FOREIGN KEY (trainer_id) REFERENCES trainer (trainer_id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (user_id) REFERENCES users (user_id) ON DELETE CASCADE ON UPDATE CASCADE
);