package com.cxz.cxzspringboot_web.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cxz.cxzspringboot_web.mapper.TestDB.TLeecodeMapper;
import com.cxz.cxzspringboot_web.model.TLeecode;
import com.cxz.util.JsonUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/8/27 10:05
 */
@Service
public class LeeCodeService {

    @Autowired
    public TLeecodeMapper tLeecodeMapper;

    public List<TLeecode> getAll(){
        List<TLeecode> list = (List<TLeecode>) tLeecodeMapper.selectList(new QueryWrapper<TLeecode>().gt("Id", 0));
        return  list;
    }

    public void read(){
        Resource resource = new ClassPathResource("static/20210825LeeCodeEasy");

        System.out.println("JsonUtil.toJson(resource) = " + JsonUtil.toJson(resource));
        return;
    }

    public void print(Resource rs){

    }

    public static String readfile(String fileName ){
        File file = new File(fileName);
        BufferedReader reader = null;
        StringBuilder sb = new StringBuilder();
        try {

            reader = new BufferedReader(new FileReader(file));


            String tempString = null;
            int line = 1;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                // 显示行号

                line++;
                sb.append(tempString);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
        return sb.toString();
    }
}
