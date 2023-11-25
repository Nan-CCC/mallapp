package com.example.shop.mapper;

import com.example.shop.VO.UserOrderGoodsVO;
import com.example.shop.entity.Goods;
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
public interface GoodsMapper extends BaseMapper<Goods> {
    List<UserOrderGoodsVO> getGoodsListByOrderId(@Param("id") Integer id);
}
