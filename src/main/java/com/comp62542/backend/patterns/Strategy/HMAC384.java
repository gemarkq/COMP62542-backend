package com.comp62542.backend.patterns.Strategy;

import com.auth0.jwt.algorithms.Algorithm;

public class HMAC384 implements Strategy{
    @Override
    public Algorithm selectChoosenAlgorithm(String signature) {
        return Algorithm.HMAC384(signature);
    }
}
