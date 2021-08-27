package com.cxz.cxzspringboot_web.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cxz.cxzspringboot_web.mapper.TestDB.OrderMapper;
import com.cxz.cxzspringboot_web.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/8/26 16:47
 */
@Service
public class OrderService {
    @Autowired
    private OrderMapper orderMapper;
    public List<Order> getOrder(QueryWrapper<Order> qw){
        return orderMapper.selectList(qw);
    }
    public List<Order> getOrderList(QueryWrapper<Order> qw){
        return orderMapper.selectAll( );
    }
}
