package com.comp62542.backend.service;


import com.comp62542.backend.dao.ActivityMapper;
import com.comp62542.backend.entity.Activity;
import com.comp62542.backend.entity.User;
import com.comp62542.backend.util.CommonUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.lang.model.util.AbstractAnnotationValueVisitor6;
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

    public Activity findActivityByName(String name) {
        return activityMapper.selectByActivityName(name);
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

    /**
     * insert activity
     * @param data include type, time, activityName
     * @return map: status 1/0 and message
     */

    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public Map<String, Object> addActivity(Map<String, Object> data) {
        Map<String, Object> map = new HashMap<>();

        String type = (String) data.get("type");
        String time = (String) data.get("time");
        String name = (String) data.get("activityName");
        User user = (User) data.get("user");

        if (StringUtils.isBlank(type)) {
            map.put("message", "type is null");
            map.put("state", 0);
            return map;
        }
        if (StringUtils.isBlank(time)) {
            map.put("message", "time is null");
            map.put("status", 0);
            return map;
        }
        if (StringUtils.isBlank(name)) {
            map.put("message", "activityName is null");
            map.put("status", 0);
            return map;
        }
        if (user == null) {
            map.put("message", "user is null");
            map.put("status", 0);
            return map;
        }

        Activity activity = new Activity();
        activity.setActivityName(name);
        activity.setStudentId(user.getStudentID());
        activity.setTime(time);
        activity.setType(type);
        Activity temp = findActivityByName(name); // 寻找是否有同名activity 取出activityId
        if (temp != null) {
            activity.setActivityId(temp.getActivityId());
        }else {
            String activityId = CommonUtils.generateUUID(); // 无activityId 则生成
            activity.setActivityId(activityId);
        }

        activityMapper.insertActivity(activity);

        map.put("message", "add activity successfully");
        map.put("status", 1);

        return map;

    }


}
