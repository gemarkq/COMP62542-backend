package com.comp62542.backend.dao;

import com.comp62542.backend.entity.Activity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

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


}
