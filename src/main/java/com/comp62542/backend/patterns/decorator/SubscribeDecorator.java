/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.comp62542.backend.patterns.decorator;

import com.comp62542.backend.entity.User;
import com.comp62542.backend.patterns.decorator.FullyRegisterDecorator;
import com.comp62542.backend.service.CourseService;
import com.comp62542.backend.util.GetBeanUtil;
import com.comp62542.backend.util.MailClient;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import sun.security.util.SignatureFileVerifier;

import java.util.List;
import java.util.Map;

/**
 *
 * @author SADIC
 */
public class SubscribeDecorator extends FullyRegisterDecorator {
     
    private Integer id;
    private String status;
    private String name;

    private MailClient mailClient = GetBeanUtil.getBean(MailClient.class);
    private TemplateEngine templateEngine = GetBeanUtil.getBean(TemplateEngine.class);

    public void sendNewsletter(List<Map<String, Object>> datas){
        for (Map<String, Object> data : datas) {
            String email = (String) data.get("email");
            System.out.println(email);
            Context context = new Context();
            context.setVariable("email", email);
            String content = (String) data.get("content");
            context.setVariable("content", content);
            String contents = templateEngine.process("/mail/demo", context);
            mailClient.sendMail(email, "NewsLetter", contents);
        }
    }
    
}
