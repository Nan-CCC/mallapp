package com.example.shop.service.impl;

import com.example.shop.entity.UserOrderGoods;
import com.example.shop.mapper.UserOrderGoodsMapper;
import com.example.shop.service.UserOrderGoodsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cjn
 * @since 2023-11-09
 */
@Service
public class UserOrderGoodsServiceImpl extends ServiceImpl<UserOrderGoodsMapper, UserOrderGoods> implements UserOrderGoodsService {

    //批量插入订单记录
    @Override
    public void batchUserOrderGoods(List<UserOrderGoods> list) {
        saveBatch(list);
    }
}
