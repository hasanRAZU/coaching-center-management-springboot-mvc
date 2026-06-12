package com.sdlc.pro.coaching_center_management.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TeacherAddRequest {

    @NotBlank
    private String name;
}
