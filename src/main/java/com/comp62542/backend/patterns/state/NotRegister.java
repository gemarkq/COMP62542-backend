/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.comp62542.backend.patterns.state;

import com.comp62542.backend.entity.User;
import com.comp62542.backend.patterns.state.State;
import com.comp62542.backend.patterns.state.StateContext;
import com.comp62542.backend.service.UserService;
import com.comp62542.backend.util.HostHolder;
import org.apache.catalina.Host;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author SADIC
 */
public class NotRegister implements State {
//    @Autowired
//    private UserService userService;
//
//    @Autowired
//    private HostHolder hostHolder;

    public void checkStatus(StateContext context, User user){
        System.out.println("current state is not registered");
        System.out.println("update status to pending status");
//        User user = hostHolder.getUser();
//        userService.updateStatus(0, user);
        context.setState(new PendingRegister());
     }
    //未注册的右上角提示警告
    public void alert(){
    
    }
    
}
