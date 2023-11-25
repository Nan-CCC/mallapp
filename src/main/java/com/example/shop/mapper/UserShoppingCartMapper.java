package com.example.shop.mapper;

import com.example.shop.VO.CartGoodsVO;
import com.example.shop.entity.UserShoppingCart;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.lettuce.core.dynamic.annotation.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author cjn
 * @since 2023-11-09
 */
public interface UserShoppingCartMapper extends BaseMapper<UserShoppingCart> {

    //查询购物车信息
    List<CartGoodsVO> getCartGoodsInfo(@Param("id") Integer id);
}
