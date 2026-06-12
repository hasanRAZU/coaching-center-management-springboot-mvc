package com.sdlc.pro.student_management_app.model;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Course {

    @Positive
    private Long id;

    @NotBlank
    private String title;
}