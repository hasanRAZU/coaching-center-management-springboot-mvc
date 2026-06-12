package com.sdlc.pro.student_management_app;

import com.sdlc.pro.student_management_app.repository.CourseRepository;
import com.sdlc.pro.student_management_app.repository.StudentRepository;
import com.sdlc.pro.student_management_app.repository.TeacherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentManagementAppApplication implements CommandLineRunner {

    private final StudentRepository studentRepository;
    private final TeacherRepository teacherRepository;
    private final CourseRepository courseRepository;
    public StudentManagementAppApplication(StudentRepository studentRepository,
                                           TeacherRepository teacherRepository,
                                           CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.teacherRepository = teacherRepository;
        this.courseRepository = courseRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(StudentManagementAppApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        studentRepository.addDefaultStudents();
        teacherRepository.addDefaultTeachers();
        courseRepository.addDefaultCourses();
    }
}


/*

coaching-center/
        │
        ├── controller/
        ├── service/
        ├── model/
        ├── repository/ (in-memory)
        │
        ├── templates/ (Thymeleaf HTML)
        └── static/

*/
