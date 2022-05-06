package com.comp62542.backend.service;

import com.comp62542.backend.dao.CourseMapper;
import com.comp62542.backend.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CourseService {

    @Autowired
    private CourseMapper courseMapper;

    public Map<String, Object> getAllCourses() {
        List<Course> courseList = courseMapper.selectAllCourse();
        List<Map<String, Object>> allCourses = new ArrayList<>();
        for (Course course : courseList) {
            Map<String, Object> data = new HashMap<>();
            data.put("courseName", course.getCourseName());
            data.put("type", course.getType());
            data.put("department", course.getDepartment());
            data.put("courseId", course.getCourseId());
            data.put("time", course.getTime());
            allCourses.add(data);
        }
        Map<String, Object> map = new HashMap<>();
        map.put("data", allCourses);
        return map;
    }
}
