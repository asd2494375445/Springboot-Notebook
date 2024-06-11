package com.springboot101.service.impl;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springboot101.entity.Activities;
import com.springboot101.mapper.ActivitiesMapper;
import com.springboot101.service.ActivitiesService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author 24943
* @description 针对表【activities】的数据库操作Service实现
* @createDate 2024-04-01 23:20:13
*/
@Service
public class ActivitiesServiceImpl extends ServiceImpl<ActivitiesMapper, Activities>
    implements ActivitiesService {

    @Override
    @CacheEvict(value = "activities", key = "#activities.id +'_'+#activities.actState")
    public  List<Activities> query_CacheEvict_key(Activities activities) {
        List<Activities> activities1 = this.getBaseMapper().selectList(
                new LambdaQueryWrapper<Activities>()
                        .eq(activities.getId() != null, Activities::getId, activities.getId())
                        .eq(activities.getActState() != null, Activities::getActState, activities.getActState())
                        .like(activities.getAddress() != null, Activities::getAddress, activities.getAddress()));
        return activities1;
    }
}




