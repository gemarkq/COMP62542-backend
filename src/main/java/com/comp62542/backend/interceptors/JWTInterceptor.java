package com.comp62542.backend.interceptors;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.comp62542.backend.dao.UserMapper;
import com.comp62542.backend.entity.User;
import com.comp62542.backend.service.UserService;
import com.comp62542.backend.util.HostHolder;
import com.comp62542.backend.util.JWTUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.rmi.rmid.ExecOptionPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Component
public class JWTInterceptor implements HandlerInterceptor {

    @Autowired
    private UserService userService;

    @Autowired
    private HostHolder hostHolder;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Map<String, Object> map = new HashMap<>();
        String token = request.getHeader("Authorization");
        System.out.println("token " + token);
        try {
            DecodedJWT verify =  JWTUtils.verify(token);
            System.out.println("************************");
            System.out.println("verify " + verify);
            String studentId = verify.getClaim("studentId").asString();
            System.out.println(studentId);
            User user = userService.findUserByStudentID(studentId);
            if(user != null) {
                hostHolder.setUsers(user);
                return true;
            }else {
                map.put("status", 0);
                String json = new ObjectMapper().writeValueAsString(map);
                response.setContentType("application/json;charset=UTF-8");
                response.getWriter().println(json);
                return false;
            }
        } catch (SignatureVerificationException e) {
            e.printStackTrace();
            map.put("msg", "invalid signature");
        } catch (TokenExpiredException e) {
            e.printStackTrace();
            map.put("msg", "token expired");
        } catch (AlgorithmMismatchException e) {
            e.printStackTrace();
            map.put("msg", "wrong Algorithm");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("msg", "invalid token");
        }
        map.put("status", 0);
        String json = new ObjectMapper().writeValueAsString(map);
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().println(json);
        return false;
    }
}
