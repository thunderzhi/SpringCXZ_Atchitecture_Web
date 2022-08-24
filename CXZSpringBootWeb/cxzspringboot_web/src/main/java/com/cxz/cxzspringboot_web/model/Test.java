package com.cxz.cxzspringboot_web.model;

import com.cxz.util.JsonUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/8/23 16:17
 */
public class Test {
    public static void main(String[] args) {
        String path = "D:\\Project\\Java\\github\\SpringCXZ_Atchitecture_Web\\CXZSpringBootWeb\\cxzspringboot_web\\src\\main\\resources\\static\\202208230001";

        String cont = readfile(path);
        Root root = JsonUtil.toObject(Root.class,cont);
        List<JsonRootBean> rootlist = root.getlist();
        List<TLeetcodeCase> tlist = new ArrayList<>();
        for (JsonRootBean jrb: rootlist) {
            TLeetcodeCase model = new TLeetcodeCase();
            Leetcode leetcode = jrb.getLeetcode();
            model.setCcid(jrb.getId());
            model.setFrequency(jrb.getValue());
            model.setContent(leetcode.getContent());
            model.setCasename(leetcode.getTitle());
            model.setLcid(String.valueOf(leetcode.getQuestion_id()));
            model.setLastcheckdate(jrb.getTime());
            model.setLevel(leetcode.getLevel());
            model.setFrontendid(leetcode.getFrontend_question_id());
            model.setSlug_title(leetcode.getSlug_title());
            tlist.add(model);
        }

        System.out.println("jrb = " + root);

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
