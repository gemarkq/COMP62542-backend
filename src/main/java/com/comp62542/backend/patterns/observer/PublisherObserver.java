package com.comp62542.backend.patterns.observer;

import com.comp62542.backend.util.CommonUtils;

public class PublisherObserver extends Observer{
    @Override
    public void update() {
        newsletterId = CommonUtils.generateUUID();
        System.out.println("publishing the newsletter");
    }
}
