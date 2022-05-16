package com.comp62542.backend.service;

import com.comp62542.backend.dao.NewsletterMapper;
import com.comp62542.backend.entity.Newsletter;
import com.comp62542.backend.patterns.observer.SubjectNewsletter;
import com.comp62542.backend.patterns.observer.SubscriberObserver;
import org.apache.commons.lang3.StringUtils;
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

    public Map<String, Object> subscribeNewsletter(String studentId, String newsletterId) {
        Map<String, Object> map = new HashMap<>();
        if (StringUtils.isBlank(studentId)) {
            map.put("status", 0);
            map.put("message", "user is null");
            return map;
        }
        if (StringUtils.isBlank(newsletterId)) {
            map.put("status", 0);
            map.put("message", "newsletterId is null");
            return map;
        }
        Newsletter newsletter = newsletterMapper.selectNewsletterByStudentIdAndNewsletterId(studentId, newsletterId);
        if(newsletter != null) {
            map.put("status", 0);
            map.put("message", "You have already subscribed this newsletter");
            return map;
        }
        newsletterMapper.insertNewsletter(studentId, newsletterId);
        map.put("status", 1);
        map.put("message", "Subscribe newsletter successfully");
        SubjectNewsletter subjectNewsletter = new SubjectNewsletter();
        new SubscriberObserver(subjectNewsletter);
        System.out.println("Subscribe successfully");
        return map;

    }

}
