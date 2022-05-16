package com.comp62542.backend.service;

import com.comp62542.backend.dao.UserMapper;
import com.comp62542.backend.entity.User;
import com.comp62542.backend.util.JWTUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User findUserByStudentID(String StudentID) {
        return userMapper.selectByStudentId(StudentID);
    }

    public User findUserById(int id) {
        return userMapper.selectById(id);
    }

    public void updateToFullyRegistered(int status, User user) {
        userMapper.updateStatus(2, user.getStudentID());
    }

    public Map<String, Object> updateStatus(int status, User user) {
        Map<String, Object> map = new HashMap<>();
        if (StringUtils.isBlank(user.getStudentID())) {
            map.put("status", 0);
            map.put("message", "user is null");
            return map;
        }
        if (status == 0) {
            userMapper.updateStatus(1, user.getStudentID());
        }else if(user.getStatus() == 1) {
            map.put("status", 0);
            map.put("message", "student status is already 1");
            return map;
        }else {
            map.put("status", 0);
            map.put("message", "student status is fully registered");
            return map;
        }
        map.put("status", 1);
        map.put("message", "update status successfully");
        return map;
    }

    public Map<String, Object> login(String studentId) {
        Map<String, Object> map = new HashMap<>();

        if(StringUtils.isBlank(studentId)) {
            map.put("studentIdMsg", "studnetId can not be empty!");
            return map;
        }
        User user = userMapper.selectByStudentId(studentId);

        // status：0 登入成功，status：1 登入成功
        if(user == null) {
            map.put("status", 0);
            map.put("user", user);
            return map;
        }

        // JWT token
        Map<String, String> payload = new HashMap<>();
        payload.put("studentId", user.getStudentID());
        payload.put("name", user.getName());
        String token = JWTUtils.getToken(payload);
        map.put("token", token);
        map.put("user", user);
        map.put("status", 1);
        return map;
    }
}
