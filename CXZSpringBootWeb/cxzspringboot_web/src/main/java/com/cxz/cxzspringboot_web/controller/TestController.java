package com.cxz.cxzspringboot_web.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import java.text.MessageFormat;
import java.util.HashMap;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/8/26 15:51
 */
@Api(tags = "TEST")
@RestController
@RequestMapping("/test")
public class TestController {

    @RequestMapping(value = "/getOrderList", method = {RequestMethod.GET})
    @ApiOperation(httpMethod = "GET", value = "getOrderList")//swagger 当前接口注解
    public Map<String, List<Order>> getOrderList(OrderRequest req){
        List<Order> orderList = null;
        HashMap<String, List<Order>> map = null;
        try {
            LogUtil.WriteLog(MessageFormat.format("request: {0}",  JsonUtil.toJson(req)));
            QueryWrapper<Order> qw = new QueryWrapper<>();
            //qw.eq("OrderNo",req.getOrderno());
            orderList = orderService.getOrderList(qw);
            map = new HashMap<>(6);
        } catch (Exception e) {
            e.printStackTrace();
        }

        map.put("order",orderList);
        return map;
    }
}
