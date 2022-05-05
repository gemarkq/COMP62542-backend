package com.comp62542.backend.controller;


import com.comp62542.backend.entity.User;
import com.comp62542.backend.service.ActivityServices;
import com.comp62542.backend.util.HostHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ActivityController {

    @Autowired
    private ActivityServices activityServices;

    @Autowired
    private HostHolder hostHolder;

    @GetMapping("/activities")
    public Map<String, Object> getActivityData() {
        Map<String, Object> map = new HashMap<>();
        User user = hostHolder.getUser();
        System.out.println("user" + user);
        if(user != null) {
            String studentId = user.getStudentID();
            Map<String, Object> mapg = activityServices.activity(studentId);
            if(map.containsKey("data")) {
                map.put("status", 1);
            }else {
                map.put("status", 0);
                map.put("data", null);
            }
            return map;
        }else {
            map.put("status", 0);
            map.put("data", null);
            return map;
        }

    }



}
