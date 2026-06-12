package com.sdlc.pro.student_management_app.repository;

import com.sdlc.pro.student_management_app.model.Student;
import com.sdlc.pro.student_management_app.services.StudentService;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;




@Repository
public class StudentRepository {
    private final List<Student> students = new ArrayList<>();

    public List<Student> findAll() {
        return new ArrayList<>(students);
    }

    // add some default Students
    public void addDefaultStudents(){
        Student s1 = new Student();
        s1.setId(StudentService.studentId++);
        s1.setName("Sam Curran");

        Student s2 = new Student();
        s2.setId(StudentService.studentId++);
        s2.setName("Sam Billings");

        students.add(s1);
        students.add(s2);
    }

    public void save(Student student) {
        students.add(student);
    }

    public void delete(Long id){
        students.removeIf(student -> student.getId().equals(id));
    }


    public Student findStudentById(Long studentId) {
        return students.stream().filter(student -> student.getId().equals(studentId)).findFirst().orElse(null);
    }

    public void addCourseToExistedStudent(Long studentId, String courseName) {
        for (Student s : students) {
            if (s.getId().equals(studentId)) {

                List<String> courses = s.getCourses();

                if (!courses.contains(courseName)) {
                    courses.add(courseName);
                }
            }
        }
    }
}

