package com.cxz.cxzspringboot_web.model;

import java.util.List;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/8/23 16:23
 */
public class Root {
    private List<JsonRootBean> list;
    public void setlist(List<JsonRootBean> list) {
        this.list = list;
    }
    public List<JsonRootBean> getlist() {
        return list;
    }
}
