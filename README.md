# Student Management System (Spring Boot MVC)

A simple Student Management web application built using Spring Boot and Thymeleaf.  
It demonstrates CRUD operations and basic enrollment features using in-memory data storage.

---

## Features

- Add / View / Delete Students
- Add / View / Delete Teachers
- Add / View / Delete Courses
- Enroll students into courses
- View enrolled courses per student
- Simple dashboard UI using Thymeleaf

---

## Tech Stack

- Java 17
- Spring Boot
- Spring MVC
- Thymeleaf
- Maven
- Jakarta Validation

---

## Project Structure

- Controller → Handles HTTP requests
- Service → Business logic
- Repository → In-memory data storage
- Model → Data entities
- DTO → Form requests
- Thymeleaf → Frontend templates

---

## How to Run



```bash
mvn spring-boot:run

Open:
http://localhost:8080/dashboard