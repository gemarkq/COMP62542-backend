package com.comp62542.backend.patterns.observer;

public abstract class Observer {
    protected SubjectNewsletter subjectNewsletter;
    public String newsletterId;
    public abstract void update();

}
