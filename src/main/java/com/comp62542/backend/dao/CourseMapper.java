package com.comp62542.backend.dao;


import com.comp62542.backend.entity.Course;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CourseMapper {

    @Select({
            "select id, courseId, courseName, type, time, department, teacher from courses"
    })
    @ResultType(Course.class)
    List<Course> selectAllCourse();
}
