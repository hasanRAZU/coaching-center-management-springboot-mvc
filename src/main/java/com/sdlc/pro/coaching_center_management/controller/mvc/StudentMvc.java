package com.sdlc.pro.coaching_center_management.controller.mvc;

import com.sdlc.pro.coaching_center_management.dto.StudentAddRequest;
import com.sdlc.pro.coaching_center_management.services.CourseService;
import com.sdlc.pro.coaching_center_management.services.StudentService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/students")
public class StudentMvc {

    private final CourseService courseService;
    // instead of autowiring, cz -> field injection is not recommended
    StudentService studentService;
    public StudentMvc(StudentService studentService, CourseService courseService) {
        this.studentService = studentService;
        this.courseService = courseService;
    }


// Students
    @GetMapping
    public ModelAndView mvcStudentPage(){

        ModelAndView modelAndView = new ModelAndView("students");
        modelAndView.addObject("students", studentService.getAllStudents());
        return modelAndView;
    }

    @GetMapping("/add")
    public String  mvcAddStudentPage(){
        return "add_student";
    }


    // save
    @PostMapping("save")
    public String mvcStudentSave(@Valid @ModelAttribute StudentAddRequest studentAddRequest, RedirectAttributes redirectAttributes){

        try{
            studentService.addStudent(studentAddRequest.getName());
        }catch(Exception ignored){
            // write code for exception
        }

        redirectAttributes.addFlashAttribute("message", "Student successfully saved");

        return "redirect:/students";
    }

    // delete

    @GetMapping("/delete/{id}")
    public String mvcDeleteStudentPage(@PathVariable Long id, RedirectAttributes redirectAttributes){
        studentService.deleteStudent(id);

        redirectAttributes.addFlashAttribute("message", "Student successfully deleted");

        return "redirect:/students";
    }

// enrollment

    @GetMapping("/enroll/{id}")
    public ModelAndView mvcEnrollPage(@PathVariable Long id){

        ModelAndView modelAndView = new ModelAndView("enroll_course");
        modelAndView.addObject("student", studentService.getStudentById(id));
        modelAndView.addObject("courses", courseService.findAllCourses());

        return modelAndView;
    }

    @PostMapping("/{id}/enroll")
    public String mvcEnroll(@PathVariable("id") Long stu_id,
                            @RequestParam String courseName,
                            RedirectAttributes redirectAttributes){


        studentService.enrollCourse(stu_id, courseName);

        redirectAttributes.addFlashAttribute("message", "Course successfully enrolled");
        return "redirect:/students";
    }






    // remove course
    @GetMapping("/{id}/remove-course")
    public String removeCourse(
            @PathVariable Long id,
            @RequestParam String courseName,
            RedirectAttributes redirectAttributes){


        redirectAttributes.addFlashAttribute("message", "Course successfully removed");
        return "redirect:/students";
    }
}
