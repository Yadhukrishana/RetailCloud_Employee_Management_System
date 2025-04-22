# RetailCloud  Employee Management System – Spring Boot

A production-ready **Spring Boot application** to manage employees and departments, featuring full CRUD operations, relationship mapping, filtering, and a custom lookup API for names and IDs.

---

## Tech Stack

-Java 17+

-Spring Boot

-Spring Data JPA

-H2 db

-Maven

-Lombok

-REST API

---

##  Features

- Employee & Department CRUD operations  
- One-to-many relationship between Department and Employees  
- Custom lookup endpoint to fetch only employee `id` and `name`  
- JPA-based persistence  
- Clean controller → service → repository structure  
- JSON schema and database structure included

---
##  Database Structure

###  Employee Table

| Column              | Type        | Description                                           |
|---------------------|-------------|-------------------------------------------------------|
| `id`                | Long (PK)   | Unique Employee ID                                    |
| `name`              | String      | Full name of the employee                             |
| `date_of_birth`     | LocalDate   | Date of birth                                         |
| `salary`            | Double      | Monthly salary                                        |
| `department_id`     | Long (FK)   | Reference to Department table                         |
| `address`           | String      | Residential address                                   |
| `role`              | String      | Job title or designation                              |
| `joining_date`      | LocalDate   | Date the employee joined                              |
| `yearly_bonus_pct`  | Double      | Annual bonus percentage (e.g., 10 for 10%)            |
| `reporting_manager_id` | Long (FK) | Self-reference to another Employee (manager)          |
| `created_at`        | Timestamp   | Record creation timestamp                             |
| `updated_at`        | Timestamp   | Record last update timestamp                          |

>  All employees  have a `reporting_manager_id` referencing another employee in the same table.

---

###  Department Table

| Column            | Type        | Description                                           |
|-------------------|-------------|-------------------------------------------------------|
| `id`              | Long (PK)   | Unique Department ID                                  |
| `name`            | String      | Department name                                       |
| `created_date`    | LocalDate   | Date the department was created                       |
| `department_head_id` | Long (FK) | Reference to Employee who heads the department        |
| `created_at`      | Timestamp   | Record creation timestamp                             |
| `updated_at`      | Timestamp   | Record last update timestamp                          |

>  `department_head_id` must reference an existing employee.


---

## Code Flow

Client Request
   ↓
Controller → Service → Repository (JPA) → Database

---

## How to run 

Clone the repository

git clone https://github.com/Yadhukrishana/RetailCloud_Employee_Management_System.git

 Build and run

./mvnw spring-boot:run


---

