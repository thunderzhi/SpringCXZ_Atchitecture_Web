package com.cxz.cxzspringboot_web.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cxz.cxzspringboot_web.mapper.CommonTest.TTest1Mapper;
import com.cxz.cxzspringboot_web.model.TTest1;
import com.cxz.cxzspringboot_web.service.ITTest1Service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cxz
 * @since 2022-09-23
 */
@Service
public class TTest1ServiceImpl extends ServiceImpl<TTest1Mapper, TTest1> implements ITTest1Service {


    @Transactional
    public String savelist(List<TTest1> list) throws Exception {
        long startTime = System.currentTimeMillis(); // 获取开始时间
        this.saveBatch(list);
        // doThing(); // 测试的代码段
        long endTime = System.currentTimeMillis(); // 获取结束时间
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
        return "OK";
    }
}
