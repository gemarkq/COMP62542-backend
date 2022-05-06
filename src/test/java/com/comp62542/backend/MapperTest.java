package com.comp62542.backend;

import com.comp62542.backend.dao.ActivityMapper;
import com.comp62542.backend.entity.Activity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

@SpringBootTest
@ContextConfiguration(classes = BackendApplication.class)
public class MapperTest {

    @Autowired
    private ActivityMapper activityMapper;

    @Test
    public void testSelectActivityByStudentId() {
        List<Activity> activity = activityMapper.selectByStudentId("10872364");
        System.out.println(activity.get(0));
    }

    @Test
    public void testSelectActivityById() {
        Activity activity = activityMapper.selectById(1);
        System.out.println(activity);
    }

    @Test
    public void testSelectActivityByActivityId() {
        Activity activity = activityMapper.selectByActivityId("100");
        System.out.println(activity);
    }

    @Test
    public void testSelectActivityByName() {
        Activity activity = activityMapper.selectByActivityName("Meeting with supervisor");
        System.out.println(activity);
    }

    @Test
    public void testInsertActivity() {
        Activity activity = new Activity();
        activity.setActivityId("102");
        activity.setActivityName("test Activity");
        activity.setType("tutorial");
        activity.setTime("3-1300-1400");
        activity.setStudentId("10872364");
        System.out.println(activityMapper.insertActivity(activity));

    }

}
