/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.comp62542.backend.patterns.Strategy;

import com.auth0.jwt.algorithms.Algorithm;

/**
 *
 * @author SADIC
 */
public interface Strategy {
    public Algorithm selectChoosenAlgorithm(String signature);
}
