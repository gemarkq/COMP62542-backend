package com.comp62542.backend.config;

import com.comp62542.backend.patterns.iterators.Iterator;
import com.comp62542.backend.patterns.iterators.UnregisteredStudentsRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class ScheduleTask {

    @Autowired
    private UnregisteredStudentsRespository unregisteredStudentsRespository;

    /**
     * remind to pay the tuition fee
     */
    @Scheduled(cron = "0 0 0 * * ?")
    public void sendDailyReminder() {
        Iterator it = unregisteredStudentsRespository.getIterator();
        while(it.hasNext()) {

        }
    }

    public static void main(String[] args) {
        UnregisteredStudentsRespository unregisteredStudentsRespository = new UnregisteredStudentsRespository();
        Iterator iter = unregisteredStudentsRespository.getIterator();
        while(iter.hasNext()) {
            System.out.println(iter.next());
        }
    }
}
