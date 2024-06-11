package com.springboot101.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springboot101.entity.Activities;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 24943
* @description 针对表【activities】的数据库操作Mapper
* @createDate 2024-04-01 23:20:13
* @Entity cn.xdd.entity.Activities
*/
@Mapper
public interface ActivitiesMapper extends BaseMapper<Activities> {

}




