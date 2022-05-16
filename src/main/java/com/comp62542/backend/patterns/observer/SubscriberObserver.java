package com.comp62542.backend.patterns.observer;

import com.comp62542.backend.dao.NewsletterMapper;
import com.comp62542.backend.service.NewsletterService;
import com.comp62542.backend.util.GetBeanUtil;
import com.comp62542.backend.util.HostHolder;

public class SubscriberObserver extends Observer{

    private NewsletterService newsletterService = GetBeanUtil.getBean(NewsletterService.class);

    private HostHolder hostHolder = GetBeanUtil.getBean(HostHolder.class);

    public SubscriberObserver(SubjectNewsletter subject) {
        this.subjectNewsletter = subject;
    }

    @Override
    public void update() {
        System.out.println("Subscribing the observer!");
        newsletterService.subscribeNewsletter(newsletterId, hostHolder.getUser().getStudentID());
    }
}
