/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.comp62542.backend.patterns.vistor;

/**
 *
 * @author SADIC
 */
public interface Course {
    public void operationCourse(CourseVisitor courseVisitor);
    public void accept(CourseVisitor courseVisitor);
}
