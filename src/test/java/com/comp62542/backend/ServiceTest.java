package com.comp62542.backend;


import com.comp62542.backend.entity.User;
import com.comp62542.backend.service.ActivityServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
@ContextConfiguration(classes = BackendApplication.class)
public class ServiceTest {

    @Autowired
    private ActivityServices activityServices;

    @Test
    public void testActivity() {
        System.out.println(activityServices.activity("10872364"));
    }

    @Test
    public void testAddActivity() {
        Map<String, Object> map = new HashMap<>();
        map.put("activityName", "Pattern Tutorial");
        map.put("type", "tutorial");
        map.put("time", "4-0900-1100");
        User user = new User();
        user.setStudentID("10872364");
        map.put("user", user);

        activityServices.addActivity(map);
        System.out.println("ok");
    }
}
