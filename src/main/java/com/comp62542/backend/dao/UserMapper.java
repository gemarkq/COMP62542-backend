package com.comp62542.backend.dao;

import com.comp62542.backend.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper {

    @Select({
            "select id, studentID, name, status, type, email " +
                    "from user " +
                    "where studentID=#{studetnID}"
    })
    User selectByStudentId(String studentID);


    @Select({
            "select id, studentID, name, status, type, email " +
                    "from user " +
                    "where id=#{id}"
    })
    User selectById(int id);

    @Update({
            "update user set status=#{status} where studentID=#{studentId}"
    })
    int updateStatus(int status, String studentId);

}
