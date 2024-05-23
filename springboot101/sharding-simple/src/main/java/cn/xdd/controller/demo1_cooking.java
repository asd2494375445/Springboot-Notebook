package cn.xdd.controller;


import com.alibaba.fastjson.JSONObject;
import jdk.nashorn.internal.runtime.logging.Logger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cooking")
@Slf4j
public class demo1_cooking {

@Autowired
    private RedisTemplate redisTemplate;
    @GetMapping("/change-username")
    public String setCookie(HttpServletResponse response) {
        // create a cookie
        Cookie cookie = new Cookie("username", "Jovan");

        //add a cookie to the response
        response.addCookie(cookie);

        return "Username is changed!";
    }
    @GetMapping("/t1")
    public String t1() {
        Object fractList110__null = redisTemplate.opsForValue().get("fract_list_1_10__null");
         log.debug("  [MYLOG]:demo1_cooking/t1  ==>fractList110__null::"+ JSONObject.toJSONString(fractList110__null)+ "<==");
         // log.debug("  [MYLOG]:demo1_cooking/t1  ==>fractList110__null::"+ JSONObject.toJSONString(fractList110__null)+ "<==");

        return "Username is changed!!!!";
    }
    @GetMapping("/readcooking")
    public String readCookie(@CookieValue(value = "username", defaultValue = "Atta") String username) {
        return "Hey! My username is " + username;
    }
    @GetMapping("/all-cookies")
    public String readAllCookies(HttpServletRequest request) {

        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            return Arrays.stream(cookies)
                    .map(c -> c.getName() + "=" + c.getValue()).collect(Collectors.joining(", "));
        }

        return "No cookies";
    }
}
