package com.comp62542.backend.patterns.Strategy;

import com.auth0.jwt.algorithms.Algorithm;

public class HMAC256 implements Strategy{

    @Override
    public Algorithm selectChoosenAlgorithm(String signature) {
        return Algorithm.HMAC256(signature);
    }
}
