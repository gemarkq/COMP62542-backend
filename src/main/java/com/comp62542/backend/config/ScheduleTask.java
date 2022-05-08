package com.comp62542.backend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class ScheduleTask {

    /**
     * remind to pay the tuition fee
     */
    @Scheduled(cron = "0 0 0 * * ?")
    public void sendDailyReminder() {

    }
}
