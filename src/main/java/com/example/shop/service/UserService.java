package com.example.shop.service;

import com.example.shop.VO.LoginResultVO;
import com.example.shop.VO.UserVO;
import com.example.shop.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.shop.query.UserLoginQuery;
import org.springframework.web.multipart.MultipartFile;

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

    User getUserInfo(Integer userId);

    //修改用户信息
    UserVO editUserInfo(UserVO userVO);

    //修改用户头像
    String editUserAvatar(Integer userId, MultipartFile file);
}
