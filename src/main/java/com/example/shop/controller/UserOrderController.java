package com.example.shop.controller;

import com.alibaba.fastjson2.JSONObject;
import com.example.shop.VO.OrderDetailVO;
import com.example.shop.VO.SubmitOrderVO;
import com.example.shop.VO.UserOrderVO;
import com.example.shop.common.exception.ServerException;
import com.example.shop.common.result.Result;
import com.example.shop.query.OrderPreQuery;
import com.example.shop.service.UserOrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static com.example.shop.common.utils.ObtainUserIdUtils.getUserId;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author cjn
 * @since 2023-11-09
 */
@Tag(name = "订单管理")
@RestController
@RequestMapping("/order")
@AllArgsConstructor
public class UserOrderController {
    private final UserOrderService userOrderService;

    @Operation(summary = "提交订单")
    @PostMapping("submit")
    public Result<JSONObject> saveUserOrder(@RequestBody @Validated UserOrderVO userOrderVO, HttpServletRequest request) {
        userOrderVO.setUserId(getUserId(request));
        Integer orderId = userOrderService.addGoodsOrder(userOrderVO);
        JSONObject json = new JSONObject();
        json.put("id", orderId);
        return Result.ok(json);
    }

    @Operation(summary = "获取订单详情")
    @GetMapping("info")
    public Result<OrderDetailVO> getOrderInfo(@RequestParam Integer id) {
        if (id == null) {
            throw new ServerException("订单信息不存在");
        }
        OrderDetailVO orderDetail = userOrderService.getOrderDetail(id);
        return Result.ok(orderDetail);
    }

    @Operation(summary = "填写订单 - 获取预付订单")
    @GetMapping("pre")
    public Result<SubmitOrderVO> getPreOrderDetail(HttpServletRequest request) {
        Integer userId = getUserId(request);
        SubmitOrderVO preOrderDetail = userOrderService.getPreOrderDetail(userId);
        return Result.ok(preOrderDetail);
    }

    @Operation(summary = "填写订单-获取立即购买订单")
    @PostMapping("prew")
    public Result<SubmitOrderVO> getPreNowOrderDetail(@RequestBody @Validated OrderPreQuery query, HttpServletRequest request) {
        query.setUserId(getUserId(request));
        SubmitOrderVO preNowOrderDetail = userOrderService.getPreNowOrderDetail(query);
        return Result.ok(preNowOrderDetail);
    }





}
