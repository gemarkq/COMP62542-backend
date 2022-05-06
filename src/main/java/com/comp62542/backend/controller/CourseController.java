package com.comp62542.backend.controller;


import com.comp62542.backend.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/optcourses")
    public Map<String, Object> getAllCourses() {
        return courseService.getAllCourses();
    }

}
