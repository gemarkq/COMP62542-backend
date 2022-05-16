/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.comp62542.backend.patterns.state;

import com.comp62542.backend.entity.User;

/**
 *
 * @author SADIC
 */
public class StateContext {
    private State state;
    private com.comp62542.backend.entity.User User;

    public StateContext(State state){
        this.state = state;
    }
    
    public State getState(){
        return this.state;
    }
    
    public void setState(State state){
        this.state = state;
    }

    public void checkStatus(User user) {
        state.checkStatus(this, user);
    }
    
}
