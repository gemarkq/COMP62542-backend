/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.comp62542.backend.patterns.decorator;

import com.comp62542.backend.patterns.vistor.Course;
import com.comp62542.backend.patterns.vistor.CourseDisplayVisitor;
import com.comp62542.backend.patterns.vistor.SupportOffice;

/**
 *
 * @author SADIC
 */
public class AllowDecorator extends FullyRegisterDecorator {
    
    private Integer id;
    private String status;
    private String name;
    
    public void allowStudentOffice(){
        Course course = new SupportOffice();
        course.operationCourse(new CourseDisplayVisitor());
    }
    
}
