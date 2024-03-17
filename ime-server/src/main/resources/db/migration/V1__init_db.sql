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

INSERT INTO ime.skill_level(name) VALUES ('EASY'), ('MEDIUM'), ('HARD');
INSERT INTO ime.category(name) VALUES ('JAVA'), ('JAVASCRIPT'), ('SPRING'), ('SPRING BOOT'), ('SQL');
INSERT INTO ime.question(category, skill, question, answer)
    VALUES
        ('JAVA', 'EASY', 'Can you change the value of a string?', 'No, a string is immutable.  When you change the value of a string a new string object is actually created.'),
        ('JAVA', 'EASY', 'What is a deadlock?', '- Deadlock - two or more threads wait forever for a lock or resource held by another thread.
- thread-1 needs lock-1 & lock-2
- thread-2 needs lock-2 & lock-1'),
        ('JAVA', 'EASY', 'Can you explain what a string buffer and string builder is?', '- Both are mutable
- StringBuffer
	- Synchronized (thread safe)
	- slower
- StringBuilder
	- Not Synchronized (NOT thread safe)
	- faster');
