package com.sdlc.pro.student_management_app.services;

import com.sdlc.pro.student_management_app.model.Student;
import com.sdlc.pro.student_management_app.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {


    // instead of autowiring
    private final StudentRepository studentRepository;
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public static long studentId = 1;


    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }


    public void addStudent(String name) {
        Student student = new Student();

        student.setId((long) studentId);
        student.setName(name);


        studentRepository.save(student);

        studentId++;
    }



    public void deleteStudent(Long id) {
         studentRepository.delete(id);
    }


    public void enrollCourse(Long studentId, String courseName) {
        studentRepository.addCourseToExistedStudent(studentId, courseName);
    }

    public void removeCourse(Long studentId, String courseName) {

    }

    public Student getStudentById(Long studentId) {
        return studentRepository.findStudentById(studentId);
    }

}
