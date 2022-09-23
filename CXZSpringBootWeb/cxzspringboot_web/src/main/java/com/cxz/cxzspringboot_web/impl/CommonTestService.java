package com.cxz.cxzspringboot_web.impl;

import com.cxz.cxzspringboot_web.mapper.CommonTest.TTest1Mapper;
import com.cxz.cxzspringboot_web.model.TTest1;
import com.cxz.util.ContextUtils;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/9/23 11:00
 */
@Service
public class CommonTestService {

    @Autowired
    private TTest1Mapper tTest1Mapper;
    @Autowired
    @Qualifier("CommonTestSqlSessionFactory")
    private SqlSessionFactory commonTestSqlSessionFactory ;//= null;
    @Autowired
    private TTest1ServiceImpl tTest1Service;

//    public CommonTestService(){
//        commonTestSqlSessionFactory =ContextUtils.getBean("CommonTestSqlSessionFactory");
//    }

    @Transactional
    public String insert(List<TTest1> list) throws Exception {
        long startTime = System.currentTimeMillis(); // 获取开始时间
        for (int i = 0; i < list.size(); i++) {
            TTest1 tTest1 = list.get(i);
            tTest1Mapper.insert(tTest1);

            if(i>4500){
                throw new Exception("error custom");
            }
        }
//        for (TTest1 tTest1 : list) {
//            tTest1Mapper.insert(tTest1);
//
//        }
        // doThing(); // 测试的代码段

        long endTime = System.currentTimeMillis(); // 获取结束时间
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
        return "OK";
    }

    public String btinsert(List<TTest1> list) throws Exception {

        long startTime = System.currentTimeMillis(); // 获取开始时间
        SqlSession session= commonTestSqlSessionFactory.openSession(ExecutorType.BATCH);
        try {
            TTest1Mapper mapper = session.getMapper(TTest1Mapper.class);
            List<TTest1> records = list; // not shown

            list.stream().forEach(t->mapper.insert(t));
            if(1==1){
                throw new Exception("error custom");
            }

            session.commit();
            session.clearCache();
        }
        finally {
            session.close();
        }
        // doThing(); // 测试的代码段

        long endTime = System.currentTimeMillis(); // 获取结束时间
        System.out.println("2程序运行时间： " + (endTime - startTime) + "ms");
        return "OK";
    }

    public String bt2insert(List<TTest1> list) throws Exception{
        return tTest1Service.savelist(list);
    }


}
