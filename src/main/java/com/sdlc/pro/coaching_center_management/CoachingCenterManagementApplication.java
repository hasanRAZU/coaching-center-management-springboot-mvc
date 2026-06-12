package com.sdlc.pro.coaching_center_management;

import com.sdlc.pro.coaching_center_management.repository.CourseRepository;
import com.sdlc.pro.coaching_center_management.repository.StudentRepository;
import com.sdlc.pro.coaching_center_management.repository.TeacherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CoachingCenterManagementApplication implements CommandLineRunner {

    private final StudentRepository studentRepository;
    private final TeacherRepository teacherRepository;
    private final CourseRepository courseRepository;
    public CoachingCenterManagementApplication(StudentRepository studentRepository,
                                               TeacherRepository teacherRepository,
                                               CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.teacherRepository = teacherRepository;
        this.courseRepository = courseRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(CoachingCenterManagementApplication.class, args);
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
