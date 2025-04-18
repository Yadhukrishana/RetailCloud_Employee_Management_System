DROP TABLE IF EXISTS employees;
DROP TABLE IF EXISTS departments;

CREATE TABLE departments (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255),
    created_at DATE,
    department_head_id BIGINT
);



CREATE TABLE employees(
id BIGINT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(255),
date_of_birth DATE,
salary DOUBLE,
address VARCHAR(255),
role VARCHAR(255),
joining_date DATE,
yearly_bonus_percentage DOUBLE,
department_id BIGINT,
reporting_manager_id BIGINT
);

ALTER TABLE employees
    ADD CONSTRAINT fk_employee_department
    FOREIGN KEY (department_id) REFERENCES departments(id);

ALTER TABLE employees
    ADD CONSTRAINT fk_employee_manager
    FOREIGN KEY (reporting_manager_id) REFERENCES employees(id);



ALTER TABLE employees
ADD CONSTRAINT fk_department_head
FOREIGN KEY (department_id) REFERENCES departments(id);



INSERT INTO departments (id, name, created_at) VALUES (1, 'HR', CURRENT_DATE);
INSERT INTO departments (id, name, created_at) VALUES (2, 'Engineering', CURRENT_DATE);
INSERT INTO departments (id, name, created_at) VALUES (3, 'Marketing', CURRENT_DATE);



INSERT INTO employees (id, name, date_of_birth, salary, address, role, joining_date, yearly_bonus_percentage, department_id)
VALUES
(1, 'Alice', '1990-05-01', 50000, 'City 1', 'CEO', '2015-01-01', 0.2, 1),
(2, 'Bob', '1988-03-12', 40000, 'City 2', 'HR Manager', '2018-03-01', 0.1, 1),
(3, 'Charlie', '1991-07-21', 42000, 'City 3', 'HR Executive', '2020-05-10', 0.08, 1),
(4, 'David', '1992-09-01', 60000, 'City 4', 'Tech Lead', '2016-04-18', 0.12, 2),
(5, 'Eva', '1993-01-11', 55000, 'City 5', 'Engineer', '2019-06-20', 0.1, 2),
(6, 'Frank', '1987-12-30', 47000, 'City 6', 'Engineer', '2020-02-14', 0.08, 2),
(7, 'Grace', '1994-04-04', 46000, 'City 7', 'Engineer', '2021-01-10', 0.07, 2),
(8, 'Hank', '1995-08-15', 39000, 'City 8', 'Marketing Lead', '2017-11-21', 0.1, 3),
(9, 'Ivy', '1996-02-20', 38000, 'City 9', 'Designer', '2021-06-01', 0.09, 3),
(10, 'Jack', '1997-06-06', 41000, 'City 10', 'Marketing Executive', '2022-03-12', 0.08, 3),
(11, 'Karen', '1990-01-10', 42000, 'City 11', 'HR Intern', '2023-07-01', 0.05, 1),
(12, 'Leo', '1989-11-05', 50000, 'City 12', 'Engineer', '2020-10-30', 0.1, 2),
(13, 'Mia', '1994-03-18', 46000, 'City 13', 'Engineer', '2021-12-14', 0.09, 2),
(14, 'Nathan', '1991-12-25', 49000, 'City 14', 'Marketing Analyst', '2020-08-19', 0.08, 3),
(15, 'Olivia', '1993-02-02', 51000, 'City 15', 'Marketing Strategist', '2021-05-07', 0.07, 3),
(16, 'Paul', '1995-10-12', 37000, 'City 16', 'Engineer', '2023-01-11', 0.06, 2),
(17, 'Quinn', '1986-04-15', 62000, 'City 17', 'Director', '2014-08-10', 0.15, 1),
(18, 'Rachel', '1992-11-01', 47000, 'City 18', 'HR Executive', '2021-10-05', 0.09, 1),
(19, 'Steve', '1990-07-23', 44000, 'City 19', 'Engineer', '2020-04-22', 0.08, 2),
(20, 'Tina', '1988-05-30', 43000, 'City 20', 'Designer', '2021-06-20', 0.08, 3),
(21, 'Uma', '1996-09-17', 46000, 'City 21', 'Engineer', '2022-01-15', 0.07, 2),
(22, 'Victor', '1995-12-19', 45000, 'City 22', 'Engineer', '2021-09-12', 0.08, 2),
(23, 'Wendy', '1997-03-03', 39000, 'City 23', 'Marketing Intern', '2023-02-01', 0.05, 3),
(24, 'Xavier', '1993-08-08', 47000, 'City 24', 'Engineer', '2020-11-09', 0.09, 2),
(25, 'Yara', '1994-06-06', 48000, 'City 25', 'Designer', '2021-10-10', 0.08, 3);


-- Update Reporting Managers
UPDATE employees SET reporting_manager_id = 1 WHERE id BETWEEN 2 AND 10;
UPDATE employees SET reporting_manager_id = 4 WHERE id BETWEEN 11 AND 20;
UPDATE employees SET reporting_manager_id = 8 WHERE id BETWEEN 21 AND 25;

-- Assign Department Heads
UPDATE departments SET department_head_id = 2 WHERE id = 1;
UPDATE departments SET department_head_id = 4 WHERE id = 2;
UPDATE departments SET department_head_id = 8 WHERE id = 3;