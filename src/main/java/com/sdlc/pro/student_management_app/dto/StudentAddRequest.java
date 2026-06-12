package com.sdlc.pro.student_management_app.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class StudentAddRequest {

    @NotBlank
    private String name;
}

