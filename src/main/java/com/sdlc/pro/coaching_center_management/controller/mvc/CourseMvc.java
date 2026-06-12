package com.sdlc.pro.coaching_center_management.controller.mvc;

import com.sdlc.pro.coaching_center_management.dto.CourseAddRequest;
import com.sdlc.pro.coaching_center_management.services.CourseService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/courses")
public class CourseMvc {


    private final CourseService courseService;
    public  CourseMvc(CourseService courseService) {
        this.courseService =  courseService;
    }

    // Landing Page
    @GetMapping
    public ModelAndView mvcCoursePage(){

        ModelAndView modelAndView = new ModelAndView("courses");
        modelAndView.addObject("courses", courseService.findAllCourses());

        return modelAndView;
    }


    @GetMapping("/add")
    public String addCoursePage(){
        return "add_course";
    }

    @PostMapping("/save")
    public String saveCoursePage(@Valid @ModelAttribute CourseAddRequest courseAddRequest, BindingResult bindingResult){
        courseService.addCourse(courseAddRequest.getName());
        System.out.println("Course added successfully ");
        return "redirect:/courses";
    }

    @GetMapping("/delete/{id}")
    public String  deleteCoursePage(@PathVariable Long id, RedirectAttributes redirectAttributes){
        courseService.delete(id);

        redirectAttributes.addFlashAttribute("message","Course deleted successfully");

        return "redirect:/courses";
    }
}
