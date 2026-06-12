package com.sdlc.pro.student_management_app.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TeacherAddRequest {

    @NotBlank
    private String name;
}
