package com.comp62542.backend.controller;


import com.comp62542.backend.service.ActivityServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ActivityController {

    @Autowired
    private ActivityServices activityServices;

//    @GetMapping("/activities")
//    public Map<String, Object> getActivityData() {
//
//    }



}
