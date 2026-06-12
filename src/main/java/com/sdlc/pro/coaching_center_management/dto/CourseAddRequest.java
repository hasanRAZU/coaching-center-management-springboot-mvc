package com.sdlc.pro.coaching_center_management.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseAddRequest {

    @NotBlank
    private String name;
}
