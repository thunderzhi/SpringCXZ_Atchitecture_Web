package com.cxz.cxzspringboot_web.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cxz.cxzspringboot_web.impl.LeeCodeService;
import com.cxz.cxzspringboot_web.impl.OrderService;
import com.cxz.cxzspringboot_web.model.Order;
import com.cxz.cxzspringboot_web.model.OrderRequest;
import com.cxz.cxzspringboot_web.model.TLeecode;
import com.cxz.util.JsonUtil;
import com.cxz.util.LogUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Autowired
    public OrderService orderService;

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

    @Autowired
    public LeeCodeService leeCodeService;

    @RequestMapping(value = "/getleecodeList", method = {RequestMethod.GET})
    @ApiOperation(httpMethod = "GET", value = "getleecodeList")//swagger 当前接口注解
    public Map<String, List<TLeecode>> getleecodeList(OrderRequest req){
        List<TLeecode> orderList = null;
        HashMap<String, List<TLeecode>> map = null;
        try {
            LogUtil.WriteLog(MessageFormat.format("request: {0}",  JsonUtil.toJson(req)));
            QueryWrapper<TLeecode> qw = new QueryWrapper<>();
            //qw.eq("OrderNo",req.getOrderno());
            orderList = leeCodeService.getAll();
            map = new HashMap<>(6);
        } catch (Exception e) {
            e.printStackTrace();
        }

        map.put("order",orderList);
        return map;
    }

    @RequestMapping(value = "/testread", method = {RequestMethod.GET})
    @ApiOperation(httpMethod = "GET", value = "testread")
    public Map<String,String> testread(OrderRequest req) throws IOException {
        HashMap<String, String> map = null;
        leeCodeService.read();
        map.put("testread","ok");
        return map;
    }


    @RequestMapping(value = "/addlee", method = {RequestMethod.GET})
    @ApiOperation(httpMethod = "GET", value = "addlee")
    public Map<String,String> addlee(OrderRequest req) throws IOException {
        HashMap<String, String> map = null;
        int res = leeCodeService.AddLC();
        map.put("testread", String.valueOf(res));
        return map;
    }

    @RequestMapping(value = "/getOrder", method = {RequestMethod.GET})
    @ApiOperation(httpMethod = "GET", value = "getOrder")//swagger 当前接口注解
    public Map<String, List<Order>> getOrder(OrderRequest req){
        List<Order> orderList = null;
        HashMap<String, List<Order>> map = null;
        try {
            LogUtil.WriteLog(MessageFormat.format("request: {0}",  JsonUtil.toJson(req)));
            QueryWrapper<Order> qw = new QueryWrapper<>();
            qw.eq("Id",req.getId());
            //qw.eq("OrderNo",req.getOrderno());
            orderList = orderService.getOrder(qw);
            map = new HashMap<>(6);
        } catch (Exception e) {
            e.printStackTrace();
        }

        map.put("order",orderList);
        return map;
    }

}
