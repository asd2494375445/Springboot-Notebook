package com.springboot101.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springboot101.entity.UserInfo;
import com.springboot101.service.UserInfoService;
import com.springboot101.mapper.UserInfoMapper;
import org.springframework.stereotype.Service;

/**
* @author 24943
* @description 针对表【t_user_info】的数据库操作Service实现
* @createDate 2024-04-04 10:29:38
*/
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo>
    implements UserInfoService{

}




