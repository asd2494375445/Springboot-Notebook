package com.springboot101.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springboot101.entity.Activities;
import com.springboot101.service.ActivitiesService;
import com.springboot101.mapper.ActivitiesMapper;
import org.springframework.stereotype.Service;

/**
* @author 24943
* @description 针对表【activities】的数据库操作Service实现
* @createDate 2024-04-03 21:49:00
*/
@Service
public class ActivitiesServiceImpl extends ServiceImpl<ActivitiesMapper, Activities>
    implements ActivitiesService{

}




