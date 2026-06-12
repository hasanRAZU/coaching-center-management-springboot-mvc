package com.sdlc.pro.student_management_app.repository;

import com.sdlc.pro.student_management_app.model.Teacher;
import com.sdlc.pro.student_management_app.services.TeacherService;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TeacherRepository {
    private final List<Teacher> teachers = new ArrayList<>();

    public List<Teacher> findAll() {
        return new ArrayList<> (teachers);
    }



    public void save(Teacher teacher) {
        teachers.add(teacher);
    }



    public void deleteById(Long id) {
        teachers.removeIf(teacher -> teacher.getId().equals(id));
    }

    public void addDefaultTeachers() {
        Teacher teacher1 = new Teacher();
        teacher1.setId(TeacherService.teacherId++);
        teacher1.setName("Teacher 1");

        Teacher teacher2 = new Teacher();
        teacher2.setId(TeacherService.teacherId++);
        teacher2.setName("Teacher 2");

        teachers.add(teacher1);
        teachers.add(teacher2);
    }
}