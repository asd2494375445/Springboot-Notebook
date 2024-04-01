package com.springboot101.limit.controller;

import com.alibaba.fastjson.JSON;
import com.springboot101.limit.entity.User;
import com.springboot101.limit.util.RedisConfig;
import com.springboot101.limit.util.RedisUtil;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Random;

/**
 * @Author: 公众号：程序员小富
 * @Description:
 */
@Controller
public class RedisController {

    @Autowired
    private RedisTemplate<String, Serializable> redisTemplate;

    @Autowired
    private RedisUtil redisUtil;
//    @Autowired
//    private RedisConfig redisConfig;
    public static long getRandomNumber(int i) {
        int digits = 11; // 要生成的位数
        long min = (long) Math.pow(10, digits - 1); // 最小值
        long max = (long) Math.pow(10, digits) - 1; // 最大值
        Random random = new Random();
        long randomNumber = min + ((long) (random.nextDouble() * (max - min)));
        return randomNumber;
    }
    @GetMapping("/addKey")
    @ResponseBody
    public String addkey() {

        Random random=new Random();
        for (int i = 0; i < 100; i++) {
//            System.out.println(String.valueOf(i));
            redisTemplate.opsForValue().set("test_key_" + getRandomNumber(i), getRandomNumber(i));

        }
        return "yes";
    }
    @GetMapping("/addKey2")
    @ResponseBody
    public String addkey2() {

        Random random=new Random();
        for (int i = 0; i < 100; i++) {
//            System.out.println(String.valueOf(i));
            redisTemplate.opsForValue().set("test_key_" + getRandomNumber(i), getRandomNumber(i));

        }
        return "yes";
    }
    @GetMapping("/base")
    @ResponseBody
    public String base() {

        Random random=new Random();
        for (int i = 0; i < 100; i++) {
//            System.out.println(String.valueOf(i));
//            redisTemplate.opsForValue().set("test_key_" + getRandomNumber(i), getRandomNumber(i));

        }
        return "yes";
    }

    /**
     * demo1 添加对象
     * @return
     */
    @GetMapping("/addObject")
    @ResponseBody
    public String Object() {
        User user = new User();
        user.setName("dingdada");
        user.setAge(23);
        user.setHigh(172);
        /*
        demo1 不能直接序列化
        redisTemplate.opsForValue().set("user", (Serializable) user);
        com.springboot101.limit.entity.User cannot be cast to java.io.Serializable
         String  user1 = (String) redisTemplate.opsForValue().get("user");
        */

        redisUtil.set("userxdd",user);
        String userxdd = redisUtil.get("userxdd").toString();
        return userxdd;
    }

    /**
     * demo1 添加对象
     * @return
     */
    @GetMapping("/getObject")
    @ResponseBody
    public String getObject() {
        /*
        demo1 不能直接序列化
        redisTemplate.opsForValue().set("user", (Serializable) user);
        com.springboot101.limit.entity.User cannot be cast to java.io.Serializable
         String  user1 = (String) redisTemplate.opsForValue().get("user");
        */
        System.out.printf("yes");
        User userxdd1 =(User) redisUtil.get("userxdd");
        return userxdd1.toString();
    }

}