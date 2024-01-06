CREATE SCHEMA IF NOT EXISTS ime;

CREATE TABLE ime.category (
    id SERIAL PRIMARY KEY,
    name VARCHAR(64) UNIQUE NOT NULL,
    created_date DATE DEFAULT CURRENT_DATE
);

CREATE TABLE ime.question_answer (
    id SERIAL PRIMARY KEY,
    category INTEGER REFERENCES ime.category,
    question VARCHAR(512) NOT NULL,
    answer VARCHAR(512) NOT NULL,
    created_date DATE DEFAULT CURRENT_DATE
);
