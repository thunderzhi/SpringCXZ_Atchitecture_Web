package com.cxz.cxzspringboot_web.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.cxz.cxzspringboot_web.mapper.TestDB.OrderMapper;
import com.cxz.cxzspringboot_web.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/10/5 15:23
 */
@Service
public class TranTestService {

    @Autowired
    private OrderMapper orderMapper;

    @Transactional
    public int add(Order order){
        orderMapper.insert(order);
        int res = update(order);
        return res;
    }

    @Transactional
    public int update(Order order){
        UpdateWrapper<Order> uw = new UpdateWrapper<Order>().eq("id", order.getId());
        Order order1 = new Order();

        order1.setAmount(new BigDecimal(9999));
        int res = orderMapper.update(order1,uw);
        //int t = 1/0;
        return res;
    }

}
