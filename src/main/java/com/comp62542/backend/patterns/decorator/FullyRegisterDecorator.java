/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.comp62542.backend.patterns.decorator;

import com.comp62542.backend.patterns.FullyRegister;
import com.comp62542.backend.service.CourseService;
import com.comp62542.backend.service.UserService;
import com.comp62542.backend.util.GetBeanUtil;

/**
 *
 * @author SADIC
 */
public class FullyRegisterDecorator implements FullyRegister {
    
    private Integer id;
    private String status;
    private String name;

    private CourseService courseService = GetBeanUtil.getBean(CourseService.class);


    public void operationCourse(String studentId, String operation, String courseId) {
        if(operation.equalsIgnoreCase("delete")) {
            courseService.deleteOptCourse(studentId, courseId);
        }else if(operation.equalsIgnoreCase("add")){
            courseService.addOptCourses(studentId, courseId);
        }
    }
    
    
    
}
