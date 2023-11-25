package com.example.shop.convert;

import com.example.shop.VO.UserAddressVO;
import com.example.shop.entity.UserShippingAddress;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserAddressConvert {

    UserAddressConvert INSTANCE = Mappers.getMapper(UserAddressConvert.class);


    UserAddressVO convertToUserAddressVO(UserShippingAddress userShippingAddress);


    List<UserAddressVO> convertToUserAddressVOList(List<UserShippingAddress> list);
}
