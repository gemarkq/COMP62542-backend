/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.comp62542.backend.patterns.state;

import com.comp62542.backend.entity.User;
import com.comp62542.backend.patterns.FullyRegister;
import com.comp62542.backend.patterns.decorator.FullyRegisterDecorator;
import com.comp62542.backend.patterns.state.State;
import com.comp62542.backend.patterns.state.StateContext;
import org.springframework.stereotype.Component;

/**
 *
 * @author SADIC
 */
public class FullyRegisterAdapter implements State {
//    FullyRegister fullyregister = new FullyRegisterDecorator();
    
     public void checkStatus(StateContext context, User user){
        System.out.println("I am Fully Registered!!!");
        context.setState(this);
     }

     //对course的操作
     public void operationCourse(String studentId, String operation, String courseId){
//         fullyregister.operationCourse(studentId, operation, courseId);
     }
     
}
