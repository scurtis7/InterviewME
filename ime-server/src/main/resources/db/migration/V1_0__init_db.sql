CREATE SCHEMA IF NOT EXISTS ime;

CREATE TABLE ime.category (
    id INTEGER PRIMARY KEY,
    category VARCHAR(255) NOT NULL,
    create_date date
);

CREATE TABLE ime.question_answer (
    id INTEGER PRIMARY KEY,
    category VARCHAR(255) NOT NULL,
    question VARCHAR(255) NOT NULL,
    answer VARCHAR(255) NOT NULL
);
