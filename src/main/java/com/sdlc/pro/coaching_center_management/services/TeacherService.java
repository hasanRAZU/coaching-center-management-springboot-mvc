package com.sdlc.pro.coaching_center_management.services;


import com.sdlc.pro.coaching_center_management.model.Teacher;
import com.sdlc.pro.coaching_center_management.repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    // instead of autowiring
    private final TeacherRepository teacherRepository;
    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public static long teacherId = 1;

    public void addTeacher(String teacher_name){

        Teacher teacher = new Teacher();
        teacher.setId(teacherId);
        teacher.setName(teacher_name);

        teacherRepository.save(teacher);

        teacherId++;
    }

    public List<Teacher> getAllTeachers(){
        return teacherRepository.findAll();
    }

    public void deleteTeacher(Long teacherId){
        teacherRepository.deleteById(teacherId);
    }

}
