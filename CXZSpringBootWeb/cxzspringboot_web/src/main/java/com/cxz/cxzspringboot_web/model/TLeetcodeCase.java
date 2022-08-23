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
public class TLeecodeCase implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "Id",type = IdType.AUTO)
    private Long Id;

    @TableField("casename")
    private String casename;

    @TableField("lcid")
    private String lcid;

    @TableField("ccid")
    private String ccid;

    @TableField("frequency")
    private int frequency;

    @TableField("level")
    private int level;

    @TableField("frontendId")
    private String frontendid;



    @TableField("content")
    private String content;

}