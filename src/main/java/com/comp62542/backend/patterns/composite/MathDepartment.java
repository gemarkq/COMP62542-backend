/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.comp62542.backend.patterns.composite;

/**
 *
 * @author SADIC
 */
public class MathDepartment implements Department{
    private String name;
    
    public MathDepartment(String name) {
        this.name = name;
    }
    
    public void getDepName(){
        System.out.println(this.name);
    }
}
