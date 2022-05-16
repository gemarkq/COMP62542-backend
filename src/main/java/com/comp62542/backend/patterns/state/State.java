/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.comp62542.backend.patterns.state;

import com.comp62542.backend.entity.User;

/**
 *
 * @author SADIC
 */
public interface State {
    public void checkStatus(StateContext context, User user);
}
