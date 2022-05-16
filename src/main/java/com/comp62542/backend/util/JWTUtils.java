package com.comp62542.backend.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.comp62542.backend.patterns.Strategy.HMAC256;
import com.comp62542.backend.patterns.Strategy.StrategyContext;

import java.util.Calendar;
import java.util.Map;

public class JWTUtils {
    private static final String SIGNATURE = "qiujiankun123zhouzhiyu123xietianjie123!@#$%^";

    /**
     * 生成jwt token header.payload.signature
     */
    public static String getToken(Map<String, String> map) {
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.DATE, 7); // defaut: 7 days expired

        JWTCreator.Builder builder = JWT.create();

        StrategyContext strategyContext = new StrategyContext(new HMAC256());

        map.forEach((k, v) -> {
            builder.withClaim(k, v);
        });
        String token = builder.withExpiresAt(instance.getTime())
                .sign(strategyContext.selectChoosenAlgorithm(SIGNATURE));
        return token;
    }

    /**
     * verify JWT token
     */
    public static DecodedJWT verify(String token) {
        return JWT.require(Algorithm.HMAC256(SIGNATURE)).build().verify(token);
    }
}
