/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.comp62542.backend.patterns.Strategy;

import com.auth0.jwt.algorithms.Algorithm;

/**
 *
 * @author SADIC
 */
public class StrategyContext {
   Strategy strategy;

    public StrategyContext(Strategy strategy) {
        this.strategy = strategy;
    }

    public void Context(Strategy strategy){
       this.strategy = strategy;
   }
   
   public Algorithm selectChoosenAlgorithm(String signature){
       return strategy.selectChoosenAlgorithm(signature);
   }
}
