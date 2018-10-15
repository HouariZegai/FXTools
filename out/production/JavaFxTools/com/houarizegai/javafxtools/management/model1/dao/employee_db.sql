
-- Create database employees

DROP DATABASE IF EXISTS employees_db;

-- Create database

CREATE DATABASE employees_db;

-- Select database

USE employees_db;

-- Create table employees

CREATE TABLE employees (
	id INT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(80) NOT NULL,
	job VARCHAR(80) NOT NULL,
	age INT(3),
	gender BOOLEAN
);

-- Fill table by data (just example for testing db)

INSERT INTO employees (id, name, job, age, gender) VALUES(1, "houari","developer",  22, 1);
INSERT INTO employees (id, name, job, age, gender) VALUES(2, "mohammed", "mnager", 42, 1);
INSERT INTO employees (id, name, job, age, gender) VALUES(3, "ali", "architect", 30, 1);
INSERT INTO employees (id, name, job, age, gender) VALUES(4, "meriam", "programmer", 35, 0);
INSERT INTO employees (id, name, job, age, gender) VALUES(5, "ahmad", "designer", 27, 1);
INSERT INTO employees (id, name, job, age, gender) VALUES(6, "othmen", "system admin", 25, 1);
INSERT INTO employees (id, name, job, age, gender) VALUES(7, "fatima", "developer", 25, 0);