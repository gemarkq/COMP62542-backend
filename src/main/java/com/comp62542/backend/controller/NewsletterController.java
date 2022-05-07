package com.comp62542.backend.controller;

import com.comp62542.backend.service.NewsletterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class NewsletterController {

    @Autowired
    private NewsletterService newsletterService;

    @GetMapping("/subscribe")
    public Map<String, Object> getAllNewsletter() {
        return newsletterService.getallNewsletter();
    }
}
