# Online Hospital Appointment Booking System (MEDLIFE)

**Author**: Ishwarya

## Overview

This project aims to streamline the process of booking appointments at a local hospital in my village. To address the issue of long queues, I've developed a web-based system using HTML, CSS, JavaScript, SQL, and Java. This system allows users to book appointments online, view hospital information, and schedule appointments with doctors.

## Features

- **Home Page**: After logging in, users are directed to the home page where they can learn more about the hospital.

- **About Page**: This page provides details about the hospital, its history, and founding information.

- **Service Page**: Users can explore the types of services available at the hospital.

- **Expert Page**: Users can book appointments with doctors through this page.

- **Profile Page**: View and update your profile details and check your appointment history.

## User Flow

1. **Login**: Users start by logging into the system.

2. **Home Page**: Upon successful login, they are taken to the home page.

3. **About Page**: Users can explore the hospital's history and founding information.

4. **Service Page**: Learn about the services provided by the hospital.

5. **Expert Page**: Schedule appointments with doctors.

6. **Profile Page**: Manage profile details and view appointment history.

## Dependencies

- HTML
- CSS
- JavaScript
- Java
- SQL

#MEDLIFE
Milestones	(https://github.com/fssa-batch3/sec_a_ishwarya.sankar__corejava_project_2/milestones)



##ER DIAGRAM
[![HDDvqOP.png](https://iili.io/HDDvqOP.png)

### Attributes:  
- [ ] userId  
- [ ] email  
- [ ] password  
- [ ] name  
- [ ] phone number  
- [ ] type  
- [ ] isDeleted###



 Validations:  
- [ ] validateUser()  
- [ ] validateName()  
- [ ] validateEmail()  
- [ ] validatePassword()  
- [ ] validatePhonenumber()  
- [ ] validateDeleteUser()### Test:  
- [ ] testValidateUser()  
- [ ] testValidateEmail()  
- [ ] testValidatePassword()  
- [ ] testValidatePhonenumber()  
- [ ] testValidateName()### DAO:  
- [ ] createUser()  
- [ ] isEmailExists()### Service:  
- [ ] registerUser()###

 Test:  
- [ ] testRegistrationSuccess()  
- [ ] testRegistrationEmailEmpty()  
- [ ] testRegistrationphonenumer()  
- [ ] testRegistrationEmptyPassword()  
- [ ] testRegistrationNullPassword()  
- [ ] testRegistrationEmptyUsername()  
- [ ] testRegistrationNullUser()### Estimation  
- [ ] 6 hrs### 

Flow  

```mermaid  
flowchart TD
A[Start]  
B[Display Registration Form]  
C[User Fills out Form]  
D[Validate Input]  
E{Validation Successful?}  
F[Save User Data]  
G[Registration Successful]  
H[Display Error Messages]  
I[End]  
A --> B  
B --> C  
C --> D  
D --> E  
E -- Yes --> F  
F --> G  
E -- No --> H  
H --> B  
H --> I  
G --> I  
```



## Table of Contents

1. [Introduction](#introduction)
    - Purpose
    - Features
    - User Persona
2. [Prerequisites](#prerequisites)
    - Software Requirements
    - Database Setup
3. [Project Setup](#project-setup)
    - Java Project Creation
    - Reparo Dependencies
4. [Database](#database)
    - Entity-Relationship Diagram (ERD)
    - Database Tables
5. [Modules](#modules)
    - User Module
    - Medicine Module 
    - doctor Module
 

6. [Validations](#validations)
    - MedicineValidator Validations
    - UserValidator Validations

7. [Testing](#testing)
    - Unit Testing
8. [Exception Handling](#exception-handling)
    - Common Error Messages
    - Exception Handling
9. [Future Improvements](#future-improvements)
    - Planned Features
    - Roadmap
10. [Resources](#resources)
    - External Libraries
    - References

## Introduction

### Purpose
The purpose of this application is to know more details about the hospital and book the appointment with doctor and also they can buy medicine through online.

### Features

- Register, Login, Update, Delete User.
-Create Medicine,Update Medicine , Delete medicine , Read Medicine


### User Persona

- Admin
- Doctor
- Patient
- seller

## Prerequisites

### Software Requirements

- Java Development Kit (JDK)
- MySQL Database Server
- Integrated Development Environment

### Database Setup

- Table scripts: [Script](database_setup.sql)

## Project Setup

### Java Project Creation

- Create a new Java project
- Set up a MySQL database

### Library Dependencies

- JDBC,
- MySQL Connector,
- JUnit,

## Database

### Entity-Relationship Diagram (ERD)
[![HbuUGIe.md.png](https://iili.io/HbuUGIe.md.png)](https://freeimage.host/i/HbuUGIe)

### Database Tables

#### Table: user. 

| Field           | Type          | Null | Key | Default           | Extra |
|-----------------|---------------|------|-----|-------------------|-------|
| id              | INT           | NO   | PRI | auto_increment    |       |
| email           | varchar(50)   | NO   |     |                   |       |
| userName        |  varchar(50)  | NO   |     |                   |       |
| password        | varchar(10)   | NO   |     |                   |       |
| phone_number    | varchar(10)   | NO   |     |                   |       |
|type             | varchar(50)   | NO   |     |                   |       |
|isDeleted        | Tinyint(1)    | NO   |     | CURRENT_TIMESTAMP |       |

#### Table: medicine.

| Field           | Type          | Null | Key | Default           | Extra |
|-----------------|---------------|------|-----|-------------------|-------|
| id              | INT           | NO   | PRI | auto_increment    |       |
| medicine_name   | varchar(100)  | NO   |     |                   |       |
| medicine_rupe   | varchar(15)   | NO   |     |                   |       |
| medicine_url    | varchar(100)  | NO   |     |                   |       |
| user_id         | varchar(100)  | NO   |     |                   |       |
| is_deleted      | varchar(2048) | NO   |     |                   |       |






## Modules

### User Module :

- Add a user:
    - Allows to register new users.
- Update user details:
    - Enables to modify user information such as name, password, etc.
  
### medicine Module :

- Add a medicine:
    - Allows to register new Workshop.
- View medicine details:
    - Display detailed information about a specific medicine when selected.
- Update medicine details:
    - Enables to modify medicine information such as medicine_name, medicine_rupees, etc.
- Remove a medicine:
    - Allows to remove a medicine.

## Validations

### User Validations :

- String  Validation
- Number Validation
- password Validation
- User validation


### medicine  Validations :

- medicine_name  Validation
- medicine_rupees Validation
- 
  






























































