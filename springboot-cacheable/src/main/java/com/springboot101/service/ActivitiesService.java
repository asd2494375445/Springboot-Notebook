package com.springboot101.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.springboot101.entity.Activities;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
* @author 24943
* @description 针对表【activities】的数据库操作Service
* @createDate 2024-04-01 23:20:13
*/
public interface ActivitiesService extends IService<Activities> {

    List<Activities> query_CacheEvict_key(Activities activities) ;


}
