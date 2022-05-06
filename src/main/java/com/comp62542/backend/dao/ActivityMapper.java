package com.comp62542.backend.dao;

import com.comp62542.backend.entity.Activity;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ActivityMapper {

    @Select(
            {
                    "select id, activityID, studentID, activityName, type, time from activities where id=#{id}"
            }
    )
    Activity selectById(int id);

    @Select(
            {
                    "select id, activityID, studentID, activityName, type, time from activities where activityID=#{activityID}"
            }
    )
    Activity selectByActivityId(String activityID);

    @Select(
            {
                    "select id, activityID, studentID, activityName, type, time from activities where studentID=#{studentID}"
            }
    )
    @ResultType(Activity.class)
    List<Activity> selectByStudentId(String studentID);

    @Select({
            "select id, activityID, studentID, activityName, type, time from activities where activityName=#{activityName} limit 1"
    })
    Activity selectByActivityName(String activityName);

    @Insert({
            "insert into activities (studentID, activityName, type, time, activityID) values(#{studentID}, #{activityName}, #{type}, #{time}, #{activityID})"
    })
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertActivity(Activity activity);

}
