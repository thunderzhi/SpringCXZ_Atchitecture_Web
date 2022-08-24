package com.cxz.cxzspringboot_web.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cxz.cxzspringboot_web.impl.LCDBService;
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
@Api(tags = "TESTLC")
@RestController
@RequestMapping("/testlc")
public class TestLCController {


    @Autowired
    public LCDBService lcdbService;

    @RequestMapping(value = "/addlee", method = {RequestMethod.GET})
    @ApiOperation(httpMethod = "GET", value = "addlee")
    public Map<String,String> addlee(OrderRequest req) throws IOException {
        HashMap<String, String> map = new HashMap<>();
        int res = lcdbService.addLC();
        map.put("addlee", String.valueOf(res));
        return map;
    }



}
