package com.comp62542.backend.controller;

import com.comp62542.backend.entity.User;
import com.comp62542.backend.service.NewsletterService;
import com.comp62542.backend.util.HostHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class NewsletterController {

    @Autowired
    private NewsletterService newsletterService;

    @Autowired
    private HostHolder hostHolder;

    @GetMapping("/subscribe")
    public Map<String, Object> getAllNewsletter() {
        return newsletterService.getallNewsletter();
    }

    @PostMapping("/subscribe")
    public Map<String, Object> subscribeNewsletter(String newsletterId) {
        User user = hostHolder.getUser();
        String studentId = user.getStudentID();
        Map<String, Object> map = newsletterService.subscribeNewsletter(studentId, newsletterId);
        return map;
    }

}
