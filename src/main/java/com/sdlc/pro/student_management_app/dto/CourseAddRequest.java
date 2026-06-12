package com.sdlc.pro.student_management_app.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseAddRequest {

    @NotBlank
    private String name;
}
