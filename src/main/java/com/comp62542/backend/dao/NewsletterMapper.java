package com.comp62542.backend.dao;

import com.comp62542.backend.entity.Newsletter;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface NewsletterMapper {

    @Select({
            "select id, newsletterID, newsletterName, content from newsletter"
    })
    @ResultType(Newsletter.class)
    List<Newsletter> selectAllNewsletter();
}
