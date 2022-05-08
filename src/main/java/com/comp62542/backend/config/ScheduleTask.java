package com.comp62542.backend.config;

import com.comp62542.backend.dao.UserMapper;
import com.comp62542.backend.entity.User;
import com.comp62542.backend.patterns.iterators.Iterator;
import com.comp62542.backend.patterns.iterators.UnregisteredStudentsRespository;
import com.comp62542.backend.util.MailClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.thymeleaf.context.Context;
import org.thymeleaf.TemplateEngine;

@Configuration
@EnableScheduling
public class ScheduleTask {

    @Autowired
    private UnregisteredStudentsRespository unregisteredStudentsRespository;

    @Autowired
    private TemplateEngine templateEngine;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private MailClient mailClient;
    /**
     * remind to pay the tuition fee
     */
    @Scheduled(cron = "0 0 0 * * ?")
    public void sendDailyReminder() {
        Iterator it = unregisteredStudentsRespository.getIterator();
        while(it.hasNext()) {
            User user = (User) it.next();
            String email = user.getEmail();
            System.out.println(email);
            Context context = new Context();
            context.setVariable("email", email);
            String content = templateEngine.process("/mail/activation", context);
            mailClient.sendMail(email, "You are not fully Registered", content);
        }
    }


}
