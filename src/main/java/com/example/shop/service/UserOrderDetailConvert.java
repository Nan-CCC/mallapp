package com.example.shop.service;

import com.example.shop.VO.OrderDetailVO;
import com.example.shop.entity.UserOrder;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserOrderDetailConvert {
    UserOrderDetailConvert INSTANCE= Mappers.getMapper(UserOrderDetailConvert.class);

    OrderDetailVO convertToOrderDetailVO(UserOrder userOrder);
}
