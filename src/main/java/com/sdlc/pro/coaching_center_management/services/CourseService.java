package com.sdlc.pro.coaching_center_management.services;

import com.sdlc.pro.coaching_center_management.model.Course;
import com.sdlc.pro.coaching_center_management.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    CourseRepository courseRepository;

    public static long courseId = 1;

    private void addDefaultCourses(){

    }


    public void addCourse(String courseTitle){
        Course course = new Course();
        course.setId(courseId);
        course.setTitle(courseTitle);

        courseRepository.save(course);
        courseId++;
    }

    public List<Course> findAllCourses() {
        return courseRepository.findAll();
    }

    public void delete(Long id) {
        courseRepository.delete(id);
    }
}
