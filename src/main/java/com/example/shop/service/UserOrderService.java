package com.example.shop.service;

import com.example.shop.VO.OrderDetailVO;
import com.example.shop.VO.SubmitOrderVO;
import com.example.shop.VO.UserOrderVO;
import com.example.shop.common.result.PageResult;
import com.example.shop.entity.UserOrder;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.shop.entity.UserOrderGoods;
import com.example.shop.query.CancelGoodsQuery;
import com.example.shop.query.OrderPreQuery;
import com.example.shop.query.OrderQuery;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author cjn
 * @since 2023-11-09
 */
public interface UserOrderService extends IService<UserOrder> {
    //提交订单
    Integer addGoodsOrder(UserOrderVO orderVO);

    OrderDetailVO getOrderDetail(Integer id);

    SubmitOrderVO getPreOrderDetail(Integer userId);

    SubmitOrderVO getPreNowOrderDetail(OrderPreQuery query);

    SubmitOrderVO getRepurchaseOrderDetail(Integer id);

    PageResult<OrderDetailVO> getOrderList(OrderQuery query);

    OrderDetailVO cancelOrder(CancelGoodsQuery query);

    void deleteOrder(List<Integer> ids,Integer userId);

    void payOrder(Integer id);
}
