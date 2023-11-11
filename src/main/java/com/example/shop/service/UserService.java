package com.example.shop.service;

import com.example.shop.VO.LoginResultVO;
import com.example.shop.VO.UserVO;
import com.example.shop.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.shop.query.UserLoginQuery;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author cjn
 * @since 2023-11-09
 */
public interface UserService extends IService<User> {
    /*
    用户登录
     */
    LoginResultVO login(UserLoginQuery query);
}
