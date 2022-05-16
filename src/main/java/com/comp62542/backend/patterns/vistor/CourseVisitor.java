/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.comp62542.backend.patterns.vistor;

import com.comp62542.backend.patterns.FullyRegister;

/**
 *
 * @author SADIC
 */
public interface CourseVisitor {
    public void visit(FullyRegister student);
    public void visit(SupportOffice officer);
}
