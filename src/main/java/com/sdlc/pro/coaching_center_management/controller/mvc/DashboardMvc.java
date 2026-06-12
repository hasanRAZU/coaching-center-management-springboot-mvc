package com.sdlc.pro.coaching_center_management.controller.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/dashboard")
public class DashboardMvc {


    @GetMapping
    public String mvcDashboard() {
        return "index";
    }
}

