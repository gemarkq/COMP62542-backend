package com.comp62542.backend.service;

import java.util.Map;

public interface CourseDesign {
    public Map<String, Object> deleteOptCourse(String studentId, String courseId);
    public Map<String, Object> addOptCourses(String studentId, String courseId);
}
