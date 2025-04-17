DROP TABLE IF EXISTS employees;
DROP TABLE IF EXISTS departments;

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
