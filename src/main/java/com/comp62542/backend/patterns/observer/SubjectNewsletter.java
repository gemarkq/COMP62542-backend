package com.comp62542.backend.patterns.observer;

import com.comp62542.backend.dao.NewsletterMapper;
import com.comp62542.backend.util.GetBeanUtil;

import java.util.ArrayList;
import java.util.List;

public class SubjectNewsletter {
    private NewsletterMapper newsletterMapper = GetBeanUtil.getBean(NewsletterMapper.class);
    
    private List<Observer> observers = new ArrayList<>();

    private int state;

    public int getState() {
        return state;
    }
    public void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void notifyAllObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
