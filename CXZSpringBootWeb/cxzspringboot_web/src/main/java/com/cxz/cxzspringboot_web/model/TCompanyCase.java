package com.cxz.cxzspringboot_web.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author cxz
 * @since 2022-08-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TCompanyCase implements Serializable {

        private static final long serialVersionUID=1L;

        @TableId(value = "Id",type = IdType.AUTO)
        private Long Id;

        private Integer companyid;

        private Integer lcid;

        private Integer dataflag;


}