package com.comp62542.backend.dao;


import com.comp62542.backend.entity.Course;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CourseMapper {

    @Select({
            "select id, courseId, courseName, type, time, department, teacher from courses"
    })
    @ResultType(Course.class)
    List<Course> selectAllCourse();

    @Select({
            "select courses.id, courses.courseId, courseName, type, time, department, teacher " +
                    "from courses inner join course_enrollment ce on courses.courseId = ce.courseId " +
                    "where ce.studentId=#{studentId} and ce.courseId=#{courseId}"
    })
    Course selectCourseByStudentIdAndCourseId(String studentId, String courseId);

    @Select({
            "select courses.id, courses.courseId, courseName, type, time, department, teacher " +
                    "from courses inner join course_enrollment ce on courses.courseId = ce.courseId " +
                    "where ce.studentId=#{studentId}"
    })
    @ResultType(Course.class)
    List<Course> selectCoursesByStudentId(@Param("studentId")String studentId);


    @Insert({
            "insert into course_enrollment(courseId, studentId) values(#{courseId}, #{studentId}) "
    })
    @Options(useGeneratedKeys = true, keyColumn = "id")
    int insertCourse(@Param("courseId")String courseId, @Param("studentId")String studentId);

    @Delete({
            "delete from course_enrollment where studentId=#{studentId} and courseId=#{courseId}"
    })
    int deleteCourseEnrollByStudentIdAndCourseId(String studentId, String courseId);
}
