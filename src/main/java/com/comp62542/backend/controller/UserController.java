package com.comp62542.backend.controller;

import com.comp62542.backend.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;


@RestController
public class UserController {

    @Autowired
    UserService userService;


    @PostMapping("/login")
    @CrossOrigin(origins = "*")
    public Map<String, Object> login(String studentId, HttpServletResponse response) {
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> loginMap = userService.login(studentId);
        if(StringUtils.isBlank(studentId)) {
            map.put("status", 0);
        }else {
            map.put("status", loginMap.get("status"));
        }
        map.put("user", loginMap.get("user"));
        if(loginMap.containsKey("token")) {
            response.addHeader("token", (String) loginMap.get("token"));
        }
        return map;
    }

}
