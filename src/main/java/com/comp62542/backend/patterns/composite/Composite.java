/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.comp62542.backend.patterns.composite;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SADIC
 */
public class Composite implements Department{
    private List<Department> depList;
    
    public Composite(){
        this.depList = new ArrayList(); 
    }
    
    public void getDepName(){
        for(Department dep:depList){
            dep.getDepName();
        }
    }
    
    public void addDep(Department dep){
        depList.add(dep);
    }
    
    
    public void removeDep(Department dep){
        depList.remove(dep);
    }
}
