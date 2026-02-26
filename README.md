Java University Management System

Project Overview
This project is a Java based University Management System built using Object Oriented Programming (OOP) principles, Java Collections, Streams API, and File Persistence.

It simulates a realworld academic system where students can be registered, enrolled in courses, and evaluated based on GPA.



 Features

- Register Students  
- Create Courses  
- Enroll Students in Courses  
- Prevent duplicate enrollment (Custom Exception)  
- Handle course capacity (Custom Exception)  
- Track GPA using course grades  
- Find Top Student (Streams API)  
- Calculate Average GPA  
- Generate Dean’s List (GPA ≥ 3.5)  
- Save & Load Data using File I/O  



 Concepts Used

 Object-Oriented Programming (OOP)
- Inheritance (`Student`, `Instructor` → `Person`)
- Polymorphism (`calculateTuition()` overridden)
- Encapsulation (private fields + getters/setters)
- Abstraction (`Person` is abstract)

 Java Collections
- `List<Student>` → course roster
- `Map<Course, Double>` → student grades

Exception Handling
- `CourseFullException`
- `StudentAlreadyEnrolledException`

 Streams API
- Find top student
- Calculate average GPA
- Filter Dean’s List

File Handling
- Save data using `ObjectOutputStream`
- Load data using `ObjectInputStream`

---

Project Structure


src/
│
├── Person.java
├── Student.java
├── UndergraduateStudent.java
├── GraduateStudent.java
├── Instructor.java
├── Course.java
├── UniversityManager.java
├── FileManager.java
├── CourseFullException.java
├── StudentAlreadyEnrolledException.java
└── Main.java
