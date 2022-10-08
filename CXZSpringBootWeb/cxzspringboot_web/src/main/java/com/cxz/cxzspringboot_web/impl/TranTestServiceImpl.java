package com.cxz.cxzspringboot_web.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.cxz.cxzspringboot_web.mapper.TestDB.OrderMapper;
import com.cxz.cxzspringboot_web.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import sun.misc.ProxyGenerator;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/10/7 15:35
 */
@Service
public class TranTestServiceImpl {

    @Resource
    public TranTestServiceImpl tranTestServiceImpl;

    @Autowired
    private OrderMapper orderMapper;


    public int addtest1(Order order){
        int res = insert(order);
        return res;
    }

    public int addtest2(Order order){
        TranTestServiceImpl t1 = this;
        int res = this.insert(order);
        return res;
    }

    @Transactional
    public int addtest3(Order order){
        int res = this.insert(order);
        return res;
    }

    @Transactional
    public int addtest4(Order order){
        int res = this.insert2(order);
        System.out.println("err:");
        System.out.println("err:"+1/0);
        return res;
    }

    @Transactional
    public int addtest5(Order order){
        TranTestServiceImpl t1 = this;
        TranTestServiceImpl t2 = tranTestServiceImpl;
        orderMapper.insert(order);
        //ProxyGenerator.generateProxyClass()
        int res = tranTestServiceImpl.insert2(order);

        System.out.println("err:");
        System.out.println("err:"+1/0);
        return res;
    }


    @Transactional
    public int insert(Order order){
        int res = orderMapper.insert(order);
        System.out.println("err:");
        System.out.println("err:"+1/0);
        return res;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public int insert2(Order order){
        int res = orderMapper.insert(order);
        return res;
    }

    @Transactional
    public int update(Order order){
        UpdateWrapper<Order> uw = new UpdateWrapper<Order>().eq("id", order.getId());
        Order order1 = new Order();

        order1.setAmount(new BigDecimal(888));
        int res = orderMapper.update(order1,uw);
        //int t = 1/0;
        return res;
    }


}
