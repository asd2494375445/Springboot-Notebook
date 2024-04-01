package com.springboot101.mongdb.controller;

import com.springboot101.mongdb.dao.StudentDao;
import com.springboot101.mongdb.pojo.Student;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping
@Slf4j
public class test {

    @Autowired
    StudentDao studentDao;
    @RequestMapping("/xdd")
    private String t1(){
        List<Student> all = studentDao.findAll();
         log.debug("  [MYLOG]:test/t1  ==>all::"+all+ "<==");
        return all.toString();
    }
}
