package com.cxz.cxzspringboot_web.controller;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.cxz.cxzspringboot_web.impl.TranTestService;
import com.cxz.cxzspringboot_web.impl.TranTestServiceImpl;
import com.cxz.cxzspringboot_web.model.Order;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/10/5 15:22
 */
@Api(tags = "TranTest")
@RestController
@RequestMapping("/trantest")
public class TranTestController {

    @Autowired
    private TranTestService tranTestService;

    @Autowired
    private TranTestServiceImpl tranTestServiceimpl;

    // int XA model transaction work correctly
    @RequestMapping(value = "/addbyinsert", method = {RequestMethod.GET})
    @ApiOperation(httpMethod = "GET", value = "addbyinsert")//swagger 当前接口注解
    public Map<String,String> addbyinsert() throws Exception {
        HashMap<String, String> map = new HashMap<>();
        Order order = new Order();

        order.setOrderno("666");
        order.setCreatetime(LocalDateTime.now());
        order.setDataflag(1);
        order.setUsername("test1");
        order.setAmount(new BigDecimal("1"));
        int res = tranTestService.add(order);
        map.put("addbyinsert", String.valueOf(res));
        return map;
    }

    //
    @RequestMapping(value = "/addtest1", method = {RequestMethod.GET})
    @ApiOperation(httpMethod = "GET", value = "addtest1")//swagger 当前接口注解
    public Map<String,String> addtest1() throws Exception {
        HashMap<String, String> map = new HashMap<>();
        Order order = new Order();
        order.setOrderno("666");
        order.setCreatetime(LocalDateTime.now());
        order.setDataflag(1);
        order.setUsername("test1");
        order.setAmount(new BigDecimal("111"));
        int res = tranTestServiceimpl.addtest1(order);
        map.put("addtest1", String.valueOf(res));
        return map;
    }

    @RequestMapping(value = "/addtest2", method = {RequestMethod.GET})
    @ApiOperation(httpMethod = "GET", value = "addtest2")//swagger 当前接口注解
    public Map<String,String> addtest2() throws Exception {
        HashMap<String, String> map = new HashMap<>();
        Order order = new Order();
        order.setOrderno("666");
        order.setCreatetime(LocalDateTime.now());
        order.setDataflag(1);
        order.setUsername("test1");
        order.setAmount(new BigDecimal("222"));
        int res = tranTestServiceimpl.addtest2(order);
        map.put("addtest2", String.valueOf(res));
        return map;
    }

    @RequestMapping(value = "/addtest3", method = {RequestMethod.GET})
    @ApiOperation(httpMethod = "GET", value = "addtest3")//swagger 当前接口注解
    public Map<String,String> addtest3() throws Exception {
        HashMap<String, String> map = new HashMap<>();
        Order order = new Order();
        order.setOrderno("666");
        order.setCreatetime(LocalDateTime.now());
        order.setDataflag(1);
        order.setUsername("test1");
        order.setAmount(new BigDecimal("333"));
        int res = tranTestServiceimpl.addtest3(order);
        map.put("addtest3", String.valueOf(res));
        return map;
    }

    @RequestMapping(value = "/addtest4", method = {RequestMethod.GET})
    @ApiOperation(httpMethod = "GET", value = "addtest4")//swagger 当前接口注解
    public Map<String,String> addtest4() throws Exception {
        HashMap<String, String> map = new HashMap<>();
        Order order = new Order();
        order.setOrderno("666");
        order.setCreatetime(LocalDateTime.now());
        order.setDataflag(1);
        order.setUsername("test1");
        order.setAmount(new BigDecimal("444"));
        int res = tranTestServiceimpl.addtest4(order);
        map.put("addtest4", String.valueOf(res));
        return map;
    }
    @RequestMapping(value = "/addtest5", method = {RequestMethod.GET})
    @ApiOperation(httpMethod = "GET", value = "addtest5")//swagger 当前接口注解
    public Map<String,String> addtest5() throws Exception {
        HashMap<String, String> map = new HashMap<>();
        Order order = new Order();
        order.setOrderno("666");
        order.setCreatetime(LocalDateTime.now());
        order.setDataflag(1);
        order.setUsername("test1");
        order.setAmount(new BigDecimal("555"));
        int res = tranTestServiceimpl.addtest5(order);
        map.put("addtest5", String.valueOf(res));
        return map;
    }
}
