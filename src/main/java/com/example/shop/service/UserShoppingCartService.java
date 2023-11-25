package com.example.shop.service;

import com.example.shop.VO.CartGoodsVO;
import com.example.shop.entity.UserShoppingCart;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.shop.query.CartQuery;
import com.example.shop.query.EditCartQuery;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author cjn
 * @since 2023-11-09
 */
public interface UserShoppingCartService extends IService<UserShoppingCart> {

    //添加购物车
    CartGoodsVO addShopCart(CartQuery query);

    //购物车列表
    List<CartGoodsVO> shopCartList(Integer userId);

    //修改购物车
    CartGoodsVO editCart(EditCartQuery query);

    //删除/清空购物车
    void removeCartGoods(Integer userId,List<Integer> ids);


    //购物车全选/取消全选
    void editCartSelected(Boolean selected,Integer userId);
}
