package com.cxz.cxzspringboot_web.impl;

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
 * @date 2021/8/27 21:41
 */
@Service
public class LeeCodeService {

    @Autowired
    private TLeecodeMapper tLeecodeMapper;

    public int AddLC() throws IOException {
        Resource resource = new ClassPathResource("static/20210825LeeCodeEasy");
        String txt =readfile(resource.getFile());
        int i =0 ;
        List<TLeecode> tLeecode = JsonUtil.toList(TLeecode.class, txt);
        for (TLeecode item : tLeecode) {

            i+=tLeecodeMapper.insert(item);
        }
        return i;
    }

    public void read() throws IOException {
        Resource resource = new ClassPathResource("static/20210825LeeCodeEasy");
        print(resource);
        //System.out.println("JsonUtil.toJson(resource) = " + JsonUtil.toJson(resource));
        return;
    }

    public void print(Resource rs) throws IOException {
        File file = rs.getFile();
        String txt =readfile(file);
        System.out.println("txt = " + txt);
    }


    public  String readfile(File file ){
        //File file = new File(fileName);
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
