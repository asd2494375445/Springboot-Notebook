package com.springboot101.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.springboot101.entity.Activities;
import com.springboot101.entity.UserInfo;
import com.springboot101.service.ActivitiesService;
import com.springboot101.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.UUID;

@RestController
@RequestMapping("/redis")
@Slf4j
public class demo1 {
    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private ActivitiesService activitiesService;

    @Autowired
    private UserInfoService userInfoService;

    /**
     * redisTemplate 实现string查询
     * @return
     */
    @RequestMapping("/string")
    public String t1(){
        redisTemplate.opsForValue().set("xdd","xdd_value_2");
        return (String) redisTemplate.opsForValue().get("xdd");
    }

    /**
     * 十万条的string数据对查询有没有影响
     * @return
     */
    @RequestMapping("/add")
    public String t2(@RequestBody UserInfo UserInfo){

        // String jsonString = JSON.toJSONString(activities);
        // Activities activities = JSON.parseObject(jsonString, Activities.class);
        UserInfo.setCreateTime(LocalDateTime.now());
        boolean save = userInfoService.save(UserInfo);
        // UserInfo byId = userInfoService.getById(1);
        return JSON.toJSONString(save);
    }
    @RequestMapping("/addRedis")
    public String addRedis(@RequestBody UserInfo UserInfo){
        String string = UUID.randomUUID().toString().replace("-","");
         log.debug("  [MYLOG]:demo1/addRedis  ==>string::"+ JSONObject.toJSONString(string)+ "<==");
        redisTemplate.opsForValue().set(string,JSON.toJSONString(UserInfo));

        // Assert.isNull(string,"string is null");
        return JSON.toJSONString(string);
    }
    @RequestMapping("/insertToDB")
    public String insertToDB(@RequestBody UserInfo UserInfo){

        String key= (String) redisTemplate.randomKey();
        String res = (String) redisTemplate.opsForValue().get(key);
        UserInfo userInfo = JSON.parseObject(res, UserInfo.class);
        userInfo.setCreateTime(LocalDateTime.now());
        userInfoService.save(userInfo);
        redisTemplate.opsForValue().getAndDelete(key);
        return JSON.toJSONString(userInfo);
    }
}
