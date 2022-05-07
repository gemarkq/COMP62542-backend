package com.comp62542.backend.controller;


import com.comp62542.backend.entity.User;
import com.comp62542.backend.service.CourseService;
import com.comp62542.backend.util.HostHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private HostHolder hostHolder;

    @GetMapping("/optcourses")
    public Map<String, Object> getAllCourses() {
        return courseService.getAllCourses();
    }

    @PostMapping("/optcourses")
    public Map<String, Object> addOptCourses(String courseId) {
        User user = hostHolder.getUser();
        if (user.getStatus() == 0) {
            Map<String, Object> map = new HashMap<>();
            map.put("status", 0);
            map.put("message", "student is not fully registered");
            return map;
        }
        Map<String, Object> map = courseService.addOptCourses(user.getStudentID(), courseId);
        return map;
    }

    @DeleteMapping("/optcourses")
    public Map<String, Object> deleteCourses(String courseId) {
        User user = hostHolder.getUser();
        String studentId = user.getStudentID();
        Map<String, Object> map = courseService.deleteOptCourse(studentId, courseId);
        return map;
    }

}
