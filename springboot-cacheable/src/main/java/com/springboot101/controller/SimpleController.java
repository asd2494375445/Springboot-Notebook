package com.springboot101.controller;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.springboot101.entity.Activities;
import com.springboot101.pojo.CommonResult;
import com.springboot101.service.ActivitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/simple")
public class SimpleController {

    @Autowired
    private ActivitiesService activitiesService;
    @PostMapping("/create")
    public String test(@RequestBody  Activities activities) {
        boolean save = activitiesService.save(activities);
        // throw new RuntimeException();
        return JSONObject.toJSONString(activities);
    }

    /**
     * 无参
     * activities::Activities [Hash = -24050722, id=63, actState=null, actStateText=null, address=null, areaId=null, areaName=null, coverUrl=null, currentStage=null, endTime=null, foyer=null, maxApplyEndTime=null, minApplyStartTime=null, name=null, stagesId=null, startTime=null, serialVersionUID=1]
     * @param activities
     * @return
     */
    @PostMapping("/query_nokey")
    @Cacheable(value = "activities")
    public String query_nokey(@RequestBody  Activities activities) {
        List<Activities> activities1 = activitiesService.getBaseMapper().selectList(
                new LambdaQueryWrapper<Activities>()
                        .eq(activities.getId() != null, Activities::getId, activities.getId()));
        return JSONObject.toJSONString(activities1);
    }
    /**
     * 有key activities::63
     * @param activities
     * @return
     */
    @PostMapping("/query_key")
    @Cacheable(value = "activities",key = "#activities.id")
    public String query_key(@RequestBody  Activities activities) {
        List<Activities> activities1 = activitiesService.getBaseMapper().selectList(
                new LambdaQueryWrapper<Activities>()
                        .eq(activities.getId() != null, Activities::getId, activities.getId()));
        return JSONObject.toJSONString(activities1);
    }

    /**
     * #p0
     * activities::Activities [Hash = -24050722, id=63, actState=null, actStateText=null, address=null, areaId=null, areaName=null, coverUrl=null, currentStage=null, endTime=null, foyer=null, maxApplyEndTime=null, minApplyStartTime=null, name=null, stagesId=null, startTime=null, serialVersionUID=1]
     * @param activities
     * @return
     */
    @PostMapping("/query_idx")
    @Cacheable(value = "activities",key = "#p0")
    public String query_idx(@RequestBody  Activities activities) {
        List<Activities> activities1 = activitiesService.getBaseMapper().selectList(
                new LambdaQueryWrapper<Activities>()
                        .eq(activities.getId() != null, Activities::getId, activities.getId()));
        return JSONObject.toJSONString(activities1);
    }

    /**
     * 当前方法 api方法
     * activities::query_method_name

     * @param activities
     * @return
     */
    @PostMapping("/query_method_name")
    @Cacheable(value = "activities",key = "#root.method.name")
    public String query_method_name(@RequestBody  Activities activities) {
        List<Activities> activities1 = activitiesService.getBaseMapper().selectList(
                new LambdaQueryWrapper<Activities>()
                        .eq(activities.getId() != null, Activities::getId, activities.getId()));
        return JSONObject.toJSONString(activities1);
    }

    /**
     * 多参数查询
     * 问题 ：activities::1 没有参数名称
     * @param activities
     * @return
     */
    @PostMapping("/query_dup_arg_base")
    @Cacheable(value = "activities",key = "#activities.id +'_'+#activities.actState")
    public String query_dup_arg_base(@RequestBody  Activities activities) {
        List<Activities> activities1 = activitiesService.getBaseMapper().selectList(
                new LambdaQueryWrapper<Activities>()
                        .eq(activities.getId() != null, Activities::getId, activities.getId())
                        .eq(activities.getActState() != null, Activities::getActState, activities.getActState())
                        .like(activities.getAddress() != null, Activities::getAddress, activities.getAddress()));
        return JSONObject.toJSONString(activities1);
    }

    /**
     * 没有生效
     * 问题 ：activities::1 没有参数名称
     * @param activities
     * @return
     */
    @PostMapping("/query_CacheEvict_key")
    // @CacheEvict(value = "activities", key = "#activities.id +'_'+#activities.actState")
    public CommonResult< List<Activities>> query_CacheEvict_key(@RequestBody  Activities activities) {

         return CommonResult.success( activitiesService.query_CacheEvict_key(activities));
    }
}