package com.sdlc.pro.student_management_app.controller.mvc;

import com.sdlc.pro.student_management_app.dto.TeacherAddRequest;
import com.sdlc.pro.student_management_app.services.TeacherService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/teachers")
public class TeacherMvc {

    TeacherService teacherService;
    public TeacherMvc(TeacherService teacherService) {
        this.teacherService = teacherService;
    }


    // Landing
    @GetMapping
    public ModelAndView mvcTeacherPage(){
        ModelAndView modelAndView = new ModelAndView("teachers");
        modelAndView.addObject("teachers", teacherService.getAllTeachers());
        return modelAndView;
    }

    @GetMapping("/add")
    public String addTeacherPage(){
        return "add_teacher";
    }



    @PostMapping("/save")
    public String saveTeacherPage(@Valid @ModelAttribute TeacherAddRequest teacherAddRequest, RedirectAttributes redirectAttributes){
        teacherService.addTeacher(teacherAddRequest.getName());
        redirectAttributes.addFlashAttribute("message", "Teacher Added Successfully");
        return "redirect:/teachers";
    }



    @GetMapping("/delete/{id}")
    public String deleteTeacherPage(@PathVariable Long id, RedirectAttributes redirectAttributes){
        teacherService.deleteTeacher(id);
        redirectAttributes.addFlashAttribute("message", "Teacher Deleted Successfully");
        return "redirect:/teachers";
    }
}
