package com.comp62542.backend.service;

import com.comp62542.backend.dao.CourseMapper;
import com.comp62542.backend.entity.Course;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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


    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public Map<String, Object> addOptCourses(String studentId, String courseId) {
        Map<String, Object> map = new HashMap<>();
        if (StringUtils.isBlank(studentId)) {
            map.put("status", 0);
            map.put("message", "user is null");
            return map;
        }
        if (StringUtils.isBlank(courseId)) {
            map.put("status", 0);
            map.put("message", "courseId is null");
            return map;
        }

        courseMapper.insertCourse(courseId, studentId);
        map.put("status", 1);
        map.put("message", "add Course successfully");
        return map;
    }

}
