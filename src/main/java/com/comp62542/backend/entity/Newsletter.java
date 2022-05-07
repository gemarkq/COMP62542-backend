package com.comp62542.backend.entity;

import lombok.Data;


public class Newsletter {
    private int id;
    private String newsletterID;
    private String content;
    private String newsletterName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNewsletterID() {
        return newsletterID;
    }

    public void setNewsletterID(String newsletterID) {
        this.newsletterID = newsletterID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getNewsletterName() {
        return newsletterName;
    }

    public void setNewsletterName(String newsletterName) {
        this.newsletterName = newsletterName;
    }

    @Override
    public String toString() {
        return "NewsLetter{" +
                "id=" + id +
                ", newletterId='" + newsletterID + '\'' +
                ", content='" + content + '\'' +
                ", newsletterName='" + newsletterName + '\'' +
                '}';
    }
}
