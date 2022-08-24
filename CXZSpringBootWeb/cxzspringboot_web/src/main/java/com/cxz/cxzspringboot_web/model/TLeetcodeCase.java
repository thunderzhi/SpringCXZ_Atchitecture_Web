package com.cxz.cxzspringboot_web.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author cxz
 * @since 2021-08-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_leetcode_case")
public class TLeetcodeCase implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "Id",type = IdType.AUTO)
    private Long Id;

    @TableField("casename")
    private String casename;

    @TableField("slug_title")
    private String slug_title;

    @TableField("lcid")
    private String lcid;

    @TableField("ccid")
    private int ccid;

    @TableField("frequency")
    private int frequency;

    @TableField("level")
    private int level;

    @TableField("frontendId")
    private String frontendid;

    @TableField("lastcheckdate")
    private String lastcheckdate;

    public String getLastcheckdate() {
        return lastcheckdate;
    }

    public void setLastcheckdate(String lastcheckdate) {
        if(lastcheckdate.contains("T")){
            lastcheckdate = lastcheckdate.substring(0,lastcheckdate.indexOf("T"));
        }
        this.lastcheckdate = lastcheckdate;
    }

    @TableField("content")
    private String content;

}