/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.comp62542.backend.patterns.state;

import com.comp62542.backend.entity.User;
import com.comp62542.backend.patterns.state.State;
import com.comp62542.backend.patterns.state.StateContext;
import com.comp62542.backend.service.UserService;
import com.comp62542.backend.util.GetBeanUtil;
import com.comp62542.backend.util.HostHolder;
import org.apache.catalina.Host;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author SADIC
 */
//@Component
public class PendingRegister implements State {

    private UserService userService = GetBeanUtil.getBean(UserService.class);


    public void checkStatus(StateContext context, User user){
        System.out.println("current state is pending");
        System.out.println("update status to fully registered");
        if(user.getStatus() == 1) {
            userService.updateToFullyRegistered(2, user); // update to fully registered
            context.setState(new FullyRegisterAdapter());
        }else {
            System.out.println("You're not paid or alreday fully-registered");
        }
     }
    //未注册的右上角提示警告
//    public void alert(){
//
//    }
}
