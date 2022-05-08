package com.comp62542.backend.controller;

import com.comp62542.backend.annotation.AdminRequired;
import com.comp62542.backend.entity.User;
import com.comp62542.backend.service.CourseService;
import com.comp62542.backend.service.UserService;
import com.comp62542.backend.util.HostHolder;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;


@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private HostHolder hostHolder;

    @Autowired
    private CourseService courseService;


    @PostMapping("/user/login")
    public Map<String, Object> login(String studentId, HttpServletResponse response) {
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> loginMap = userService.login(studentId);
        if(StringUtils.isBlank(studentId)) {
            map.put("status", 0);
        }else {
            map.put("status", loginMap.get("status"));
        }
        map.put("user", loginMap.get("user"));
        if (loginMap.containsKey("token")) {
            map.put("token", loginMap.get("token"));
        }
        return map;
    }

    @PostMapping("/status/update")
    public Map<String, Object> updateStatus(int status) {
        System.out.println(status);
        User user = hostHolder.getUser();
        Map<String, Object> map = userService.updateStatus(status, user);
        return map;
    }

    @GetMapping("/admin/optcourses")
    @AdminRequired
    public Map<String, Object> getAllStudentsCourselists(String courseId, String studentId) {
        Map<String, Object> map = courseService.adminGetallCourses(courseId, studentId);
        return map;
    }

    @DeleteMapping("admin/optcourses")
    @AdminRequired
    public Map<String, Object> adminDeleteCourses(String courseId, String studentId) {
        Map<String, Object> map = courseService.deleteOptCourse(studentId, courseId);
        return map;
    }

}
