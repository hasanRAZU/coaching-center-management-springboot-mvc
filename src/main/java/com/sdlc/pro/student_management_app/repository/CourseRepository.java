package com.sdlc.pro.student_management_app.repository;

import com.sdlc.pro.student_management_app.model.Course;
import com.sdlc.pro.student_management_app.services.CourseService;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class CourseRepository {
    private final List<Course> courseList = new ArrayList<>();

    public void save(Course course){
        courseList.add(course);
    }


    public List<Course> findAll() {
        return new ArrayList<> (courseList);
    }

    public void delete(Long id) {
        courseList.removeIf(course -> course.getId().equals(id));
    }

    public void addDefaultCourses() {
        Course course1 = new Course();
        Course course2 = new Course();

        course1.setId(CourseService.courseId++);
        course1.setTitle("Machine Learning");

        course2.setId(CourseService.courseId++);
        course2.setTitle("Software Engineering");

        courseList.add(course1);
        courseList.add(course2);
    }
}
