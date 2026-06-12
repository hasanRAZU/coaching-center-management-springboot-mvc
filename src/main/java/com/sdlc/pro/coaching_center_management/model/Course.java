package com.sdlc.pro.coaching_center_management.model;


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