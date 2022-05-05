package com.comp62542.backend;


import com.comp62542.backend.service.ActivityServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(classes = BackendApplication.class)
public class ServiceTest {

    @Autowired
    private ActivityServices activityServices;

    @Test
    public void testActivity() {
        System.out.println(activityServices.activity("10872364"));
    }
}
