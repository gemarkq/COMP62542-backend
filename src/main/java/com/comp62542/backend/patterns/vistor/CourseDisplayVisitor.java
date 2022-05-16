/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.comp62542.backend.patterns.vistor;

import com.comp62542.backend.dao.CourseMapper;
import com.comp62542.backend.patterns.FullyRegister;
import com.comp62542.backend.service.CourseService;
import com.comp62542.backend.util.GetBeanUtil;
import com.comp62542.backend.util.HostHolder;
import org.springframework.http.converter.json.GsonBuilderUtils;

import java.util.Map;

/**
 *
 * @author SADIC
 */
public class CourseDisplayVisitor implements CourseVisitor{

    private CourseService courseservice = GetBeanUtil.getBean(CourseService.class);
    private HostHolder hostHolder = GetBeanUtil.getBean(HostHolder.class);

    public void visit(FullyRegister student) {
        //直接从service获取对课程操作
        System.out.println("student operation");
        Map<String, Object> map = courseservice.getAllCourses();
        System.out.println(map);
    }

    public void visit(SupportOffice officer) {
        //直接从service获取对课程操作
        System.out.println("officer operation");
        Map<String, Object> map = courseservice.adminGetallCourses(null, hostHolder.getUser().getStudentID());
        System.out.println(map);
    }
    
}
