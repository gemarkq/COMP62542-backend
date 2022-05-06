package com.comp62542.backend.entity;

public class Activity {
    private int id;
    private String activityID;
    private String studentID;
    private String activityName;
    private String type; // tutorial or meeting
    private String time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getActivityId() {
        return activityID;
    }

    public void setActivityId(String activityId) {
        this.activityID = activityId;
    }

    public String getStudentId() {
        return studentID;
    }

    public void setStudentId(String studentId) {
        this.studentID = studentId;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "id=" + id +
                ", activityId='" + activityID + '\'' +
                ", studentId='" + studentID + '\'' +
                ", activityName='" + activityName + '\'' +
                ", type='" + type + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
