package com.comp62542.backend.config;

import com.comp62542.backend.dao.NewsletterMapper;
import com.comp62542.backend.dao.UserMapper;
import com.comp62542.backend.entity.User;
import com.comp62542.backend.patterns.decorator.SubscribeDecorator;
import com.comp62542.backend.patterns.factory.StateFactory;
import com.comp62542.backend.patterns.iterators.Iterator;
import com.comp62542.backend.patterns.iterators.UnregisteredStudentsRespository;
import com.comp62542.backend.patterns.state.PendingRegister;
import com.comp62542.backend.patterns.state.StateContext;
import com.comp62542.backend.util.MailClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.thymeleaf.context.Context;
import org.thymeleaf.TemplateEngine;

import java.util.List;
import java.util.Map;

@Configuration
@EnableScheduling
@Slf4j
public class ScheduleTask {

    @Autowired
    private UnregisteredStudentsRespository unregisteredStudentsRespository;

    @Autowired
    private TemplateEngine templateEngine;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private MailClient mailClient;

    @Autowired
    private NewsletterMapper newsletterMapper;

//    @Autowired
//    private PendingRegister pendingRegister;
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

    @Scheduled(cron = "0 0 0 * * ?")
    public void updateStatustoFullyRegistered() {
        List<User> users = userMapper.selectPendingStudent();
//        System.out.println(users);
        if(users.size() != 0) {
            StateFactory stateFactory = new StateFactory();
            for(User user : users) {
                StateContext stateContext = new StateContext(stateFactory.getState("PendingRegister"));
                stateContext.checkStatus(user);
                log.info("Fully Registered");
                System.out.println(stateContext.getState());
            }
        }else {
            log.info("No pending status Students");
        }
    }

    @Scheduled(cron = "* * * * * ?")
    public void subscribeNewsletter() {
        List<User> users = userMapper.selectAllStudents("student");
        for(User user : users) {
            List<Map<String, Object>> datas = newsletterMapper.selectNewsletterByStudentId(user.getStudentID());
            if(datas.size() != 0) {
                SubscribeDecorator subscribeDecorator = new SubscribeDecorator();
                subscribeDecorator.sendNewsletter(datas);
            }
        }
    }



}
