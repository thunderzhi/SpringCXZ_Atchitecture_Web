package com.cxz.cxzspringboot_web.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cxz.cxzspringboot_web.mapper.LCDB.TCompanyCaseMapper;
import com.cxz.cxzspringboot_web.mapper.LCDB.TLeetcodeCaseMapper;
import com.cxz.cxzspringboot_web.model.*;
import com.cxz.util.JsonUtil;
import com.cxz.util.LogUtil;
import com.cxz.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/8/23 15:38
 */
@Service
public class LCDBService {

    @Autowired
    private TLeetcodeCaseMapper tLeetcodeCaseMapper;
    @Autowired
    private TCompanyCaseMapper tCompanyCaseMapper;


    private Map<String,TLeetcodeCase> map;
    public int add(){
        TLeetcodeCase item = new TLeetcodeCase();
        item.setCasename("test");
        item.setCcid(99999);
        item.setContent("test3");
        int res = tLeetcodeCaseMapper.insert(item);
        return res;
    }
    public List<TLeetcodeCase> getAll(){
        List<TLeetcodeCase> list = (List<TLeetcodeCase>) tLeetcodeCaseMapper.selectList(
                new QueryWrapper<TLeetcodeCase>().gt("Id", 0));
        return  list;
    }

    public void initset(){
        map = new HashMap<>();
        List<TLeetcodeCase> list = getAll();
        for (TLeetcodeCase tlc : list) {
            map.put(tlc.getLcid(),tlc);
        }
        return;
    }

    public int addLC() throws IOException {
        initset();
        String s = get("static/202208230001");
        int cid = 2;
        List<TLeetcodeCase> list = txtToList(s);
        List<TCompanyCase> tclist = new ArrayList<>();
        for (TLeetcodeCase tlc : list) {
            if (map.containsKey(tlc.getLcid())) {
                TLeetcodeCase obj = map.get(tlc.getLcid());
                if(StringUtils.isEmpty( obj.getLastcheckdate())){
                    obj.setLastcheckdate(tlc.getLastcheckdate());
                    tLeetcodeCaseMapper.updateById(obj);
                }
                continue;
            }
            int ret = tLeetcodeCaseMapper.insert(tlc);
            if(ret>0){
                map.put(tlc.getLcid(),tlc);
//                LogUtil.WriteLog(MessageFormat.format("LC main insert success: id: {0}, lcid {1} ",tLeetcodeCase.getId() , JsonUtil.toJson(req)));
                LogUtil.WriteLog(MessageFormat.format("LC main insert success: id: {0}, lcid {1} ",tlc.getId() , tlc.getLcid()));
                TCompanyCase tcc = new TCompanyCase();
                tcc.setCompanyid(cid);
                tcc.setLcid(Integer.valueOf(tlc.getLcid()));
                int ret2 = tCompanyCaseMapper.insert(tcc);
                if(ret2>0){
                    LogUtil.WriteLog(MessageFormat.format("TCC main insert success: id: {0}, lcid {1} ",tcc.getId() , tcc.getLcid()));
                }
            }
        }
        return 1;
    }


    public List<TLeetcodeCase> txtToList(String txt){

        Root root = JsonUtil.toObject(Root.class,txt);
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
            model.setLevel(leetcode.getLevel());
            model.setLastcheckdate(jrb.getTime());
            //model.setLastcheckdate();
            model.setFrontendid(leetcode.getFrontend_question_id());
            model.setSlug_title(leetcode.getSlug_title());
            tlist.add(model);
        }
        return tlist;
    }
    public String get(String path) throws IOException {
        Resource resource = CommonService.getResource(path);
        File file = resource.getFile();
        String content = CommonService.readfile(file);
        return content;
    }


}
