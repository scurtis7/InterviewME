CREATE SCHEMA IF NOT EXISTS ime;

CREATE TABLE ime.category (
    id SERIAL PRIMARY KEY,
    name VARCHAR(64) UNIQUE NOT NULL,
    created_date DATE DEFAULT CURRENT_DATE
);

CREATE TABLE ime.skill_level (
    id SERIAL PRIMARY KEY,
    name VARCHAR(8) UNIQUE NOT NULL,
    created_date DATE DEFAULT CURRENT_DATE
);

CREATE TABLE ime.question (
    id SERIAL PRIMARY KEY,
    category VARCHAR(64) NOT NULL,
    skill VARCHAR(8) NOT NULL,
    question VARCHAR(512) NOT NULL,
    answer VARCHAR(512) NOT NULL,
    created_date DATE DEFAULT CURRENT_DATE
);

INSERT INTO ime.skill_level(name) VALUES ('Easy'), ('Medium'), ('Hard');
INSERT INTO ime.category(name) VALUES ('Java'), ('JavaScript'), ('Spring'), ('Spring Boot'), ('SQL');
