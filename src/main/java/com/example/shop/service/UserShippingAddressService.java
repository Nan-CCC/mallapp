package com.example.shop.service;

import com.example.shop.VO.AddressVO;
import com.example.shop.entity.UserShippingAddress;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

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

    //获取用户收获地址
    List<AddressVO> getShippingAddress(Integer userid);

    //根据id获取指定地址
    AddressVO getShippingAddressById(Integer id);

    //删除指定地址
    Integer deleteShippingAddress(Integer id);
}
