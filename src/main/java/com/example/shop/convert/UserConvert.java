package com.example.shop.convert;

import com.example.shop.VO.LoginResultVO;
import com.example.shop.entity.User;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserConvert {
    UserConvert INSTANCE = Mappers.getMapper(UserConvert.class);


    LoginResultVO convertToLoginResultVO(User user);
}
