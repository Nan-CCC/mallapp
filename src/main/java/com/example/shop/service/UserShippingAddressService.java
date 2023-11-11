package com.example.shop.service;

import com.example.shop.VO.AddressVO;
import com.example.shop.entity.UserShippingAddress;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author cjn
 * @since 2023-11-09
 */
public interface UserShippingAddressService extends IService<UserShippingAddress> {
    Integer saveShippingAddress(AddressVO addressVO);

    //修改地址
    Integer editShippingAddress(AddressVO addressVO);
}
