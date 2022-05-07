package com.comp62542.backend.service;

import com.comp62542.backend.dao.NewsletterMapper;
import com.comp62542.backend.entity.Newsletter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class NewsletterService {

    @Autowired
    private NewsletterMapper newsletterMapper;

    public Map<String, Object> getallNewsletter() {
        List<Map<String, Object>> datalists = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();

        List<Newsletter> newsletters = newsletterMapper.selectAllNewsletter();
        for (Newsletter newsletter : newsletters) {
            Map<String, Object> data = new HashMap<>();
            data.put("newsletterId", newsletter.getNewsletterID());
            data.put("newsletterName", newsletter.getNewsletterName());
            String content = newsletter.getContent();
            int length = Math.min(100, content.length());
            data.put("preview", content.substring(0, length - 1));

            datalists.add(data);
        }
        map.put("data", datalists);
        return map;
    }

}
