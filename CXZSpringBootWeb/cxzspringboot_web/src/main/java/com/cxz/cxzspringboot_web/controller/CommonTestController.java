package com.cxz.cxzspringboot_web.controller;

import com.cxz.cxzspringboot_web.impl.CommonTestService;
import com.cxz.cxzspringboot_web.model.OrderRequest;
import com.cxz.cxzspringboot_web.model.TTest1;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/9/23 10:59
 */
@Api(tags = "CommonTest")
@RestController
@RequestMapping("/commontest")
public class CommonTestController {

    @Autowired
    public CommonTestService commonTestService;
    public static List<TTest1> ds = new ArrayList<>();
    public CommonTestController(){
        TTest1 t = new TTest1();
        for (int i = 0; i < 5000; i++) {
            ds.add(t);
        }
    }
    // this method cost 16146ms insert 5000 element each of them contains 20+ col
    // can not rollback
    @RequestMapping(value = "/addbyinsert", method = {RequestMethod.GET})
    @ApiOperation(httpMethod = "GET", value = "addbyinsert")//swagger 当前接口注解
    public Map<String,String> addbyinsert() throws Exception {
        HashMap<String, String> map = new HashMap<>();
        String res = commonTestService.insert(ds);
        map.put("addbyinsert", res);
        return map;
    }
    // this method cost 11043ms insert 5000 element each of them contains 20+ col
    @RequestMapping(value = "/btinsert", method = {RequestMethod.GET})
    @ApiOperation(httpMethod = "GET", value = "btinsert")//swagger 当前接口注解
    public Map<String,String> btinsert() throws Exception {
        HashMap<String, String> map = new HashMap<>();
        String res = commonTestService.btinsert(ds);
        map.put("btinsert", res);
        return map;
    }
    // this method cost 3614ms insert 5000 element each of them contains 20+ col

    @RequestMapping(value = "/bt2insert", method = {RequestMethod.GET})
    @ApiOperation(httpMethod = "GET", value = "bt2insert")//swagger 当前接口注解
    public Map<String,String> bt2insert() throws Exception {
        HashMap<String, String> map = new HashMap<>();
        String res = commonTestService.bt2insert(ds);
        map.put("bt2insert", res);
        return map;
    }
}
