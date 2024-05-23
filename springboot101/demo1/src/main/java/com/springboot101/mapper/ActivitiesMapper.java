package com.springboot101.mapper;

import com.springboot101.entity.Activities;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 24943
* @description 针对表【activities】的数据库操作Mapper
* @createDate 2024-04-03 21:49:00
* @Entity com.springboot101.entity.Activities
*/
@Mapper
public interface ActivitiesMapper extends BaseMapper<Activities> {

}




