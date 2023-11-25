package com.example.shop.controller;

import com.alibaba.fastjson2.JSONObject;
import com.example.shop.VO.UserOrderVO;
import com.example.shop.common.result.Result;
import com.example.shop.service.UserOrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
