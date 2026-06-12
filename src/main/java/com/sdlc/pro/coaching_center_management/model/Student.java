package com.sdlc.pro.coaching_center_management.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.UniqueElements;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@ToString
public class Student {

    @UniqueElements
    private Long id;

    @NotBlank
    private String name;

    private List<String> courses = new ArrayList<>();

}