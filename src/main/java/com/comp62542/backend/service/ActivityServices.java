package com.comp62542.backend.service;


import com.comp62542.backend.dao.ActivityMapper;
import com.comp62542.backend.entity.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ActivityServices {

    @Autowired
    private ActivityMapper activityMapper;

    public List<Activity> findActivitiesByStudentID(String studentID) {
        return activityMapper.selectByStudentId(studentID);
    }

    public Activity findActivitiesById(int id) {
        return activityMapper.selectById(id);
    }

    public Activity findActivitiesByActivityId(String activityID) {
        return activityMapper.selectByActivityId(activityID);
    }

    public Map<String, Object> activity(String StudentID) {
        List<Activity> activities = activityMapper.selectByStudentId(StudentID);
        Map<String, Object> map = new HashMap<>();
        if(activities.size() == 0) {
            map.put("msg", "No Activities");
            return map;
        }
        List<Map<String, Object>> datalist = new ArrayList<>();
        for (Activity activity : activities) {
            Map<String, Object> data = new HashMap<>();
            data.put("activityName", activity.getActivityName());
            data.put("type", activity.getType());
            data.put("time", activity.getTime());
            datalist.add(data);
        }
        map.put("data", datalist);
        return map;
    }

}
