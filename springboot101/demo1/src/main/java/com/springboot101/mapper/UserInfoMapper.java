package com.springboot101.mapper;

import com.springboot101.entity.UserInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 24943
* @description 针对表【t_user_info】的数据库操作Mapper
* @createDate 2024-04-04 10:29:38
* @Entity com.springboot101.entity.UserInfo
*/
@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfo> {

}




