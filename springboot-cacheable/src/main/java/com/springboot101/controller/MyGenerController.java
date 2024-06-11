package com.springboot101.controller;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.springboot101.config.cacheable.annotation.LybGeekCacheable;
import com.springboot101.entity.Activities;
import com.springboot101.pojo.CommonResult;
import com.springboot101.service.ActivitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/mygener")
public class MyGenerController {

    @Autowired
    private ActivitiesService activitiesService;


    /**
     * 多参数查询
     * 问题 ：activities::1 没有参数名称
     *
     * @param activities
     * @return
     */
    @PostMapping("/query_dup_arg_base")
    @LybGeekCacheable(cacheNames = "customUser", key = "#activities.id +'_'+#activities.actState", expiredTimeSecond = 40)
    public String query_dup_arg_base(@RequestBody Activities activities) {
        List<Activities> activities1 = activitiesService.getBaseMapper().selectList(
                new LambdaQueryWrapper<Activities>()
                        .eq(activities.getId() != null, Activities::getId, activities.getId())
                        .eq(activities.getActState() != null, Activities::getActState, activities.getActState())
                        .like(activities.getAddress() != null, Activities::getAddress, activities.getAddress()));
        return JSONObject.toJSONString(activities1);
    }


}