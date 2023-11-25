package com.example.shop.controller;

import com.alibaba.fastjson2.JSONObject;
import com.example.shop.VO.OrderDetailVO;
import com.example.shop.VO.SubmitOrderVO;
import com.example.shop.VO.UserOrderVO;
import com.example.shop.common.exception.ServerException;
import com.example.shop.common.result.PageResult;
import com.example.shop.common.result.Result;
import com.example.shop.query.CancelGoodsQuery;
import com.example.shop.query.OrderPreQuery;
import com.example.shop.query.OrderQuery;
import com.example.shop.service.UserOrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        System.out.println(query);
        SubmitOrderVO preNowOrderDetail = userOrderService.getPreNowOrderDetail(query);
        return Result.ok(preNowOrderDetail);
    }

    @Operation(summary = "填写订单 - 获取再次购买订单")
    @GetMapping("/repurchase")
    public Result<SubmitOrderVO> getRepurchaseOrderDetail(@RequestParam Integer id) {
        if (id == null) {
            throw new ServerException("请求参数异常");
        }
        SubmitOrderVO repurchaseOrderDetail = userOrderService.getRepurchaseOrderDetail(id);
        return Result.ok(repurchaseOrderDetail);
    }

    @Operation(summary = "订单列表")
    @PostMapping("page")
    public Result<PageResult<OrderDetailVO>> getOrderList(@RequestBody @Validated OrderQuery query, HttpServletRequest request) {
        Integer userId = getUserId(request);
        query.setUserId(userId);
        PageResult<OrderDetailVO> orderList = userOrderService.getOrderList(query);
        return Result.ok(orderList);
    }

    @Operation(summary = "取消订单")
    @PutMapping("cancel")
    public Result<OrderDetailVO> cancelOrder(@RequestBody @Validated CancelGoodsQuery query) {
        OrderDetailVO orderDetailVO = userOrderService.cancelOrder(query);
        return Result.ok(orderDetailVO);
    }

    @Operation(summary = "删除订单")
    @DeleteMapping("delete")
    public Result deleteOrder(@RequestBody List<Integer> ids, HttpServletRequest request) {
        Integer userId = getUserId(request);
        userOrderService.deleteOrder(ids, userId);
        return Result.ok();
    }

    @Operation(summary = "支付订单")
    @GetMapping("pay")
    public Result payOrder(@RequestParam Integer id) {
        if (id == null) {
            throw new ServerException("订单不存在");
        }
        userOrderService.payOrder(id);
        return Result.ok();
    }










}
