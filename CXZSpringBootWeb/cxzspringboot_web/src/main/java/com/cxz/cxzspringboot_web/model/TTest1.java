package com.cxz.cxzspringboot_web.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
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
 * @since 2022-09-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TTest1 implements Serializable {

    private static final long serialVersionUID=1L;
    @TableId(value = "Id",type = IdType.AUTO)
    private long Id;

    @TableField("A")
        private String a;

    @TableField("B")
        private String b;

    @TableField("C")
        private String c;

    @TableField("D")
        private String d;

    @TableField("E")
        private String e;

    @TableField("F")
        private String f;

    @TableField("G")
        private String g;

    @TableField("H")
        private String h;

    @TableField("I")
        private String i;

    @TableField("J")
        private String j;

    @TableField("K")
        private String k;

    @TableField("L")
        private String l;

    @TableField("M")
        private String m;

    @TableField("N")
        private String n;

    @TableField("O")
        private String o;

    @TableField("P")
        private String p;

    @TableField("Q")
        private String q;

    @TableField("R")
        private String r;

    @TableField("S")
        private String s;

    @TableField("T")
        private String t;

    @TableField("U")
        private String u;

    @TableField("V")
        private String v;

    @TableField("W")
        private String w;

    public TTest1() {
        this.a = "a";
        this.b = "b";
        this.c = "c";
        this.d = "d";
        this.e = "e";
        this.f = "f";
        this.g = "g";
        this.h = "h";
        this.i = "i";
        this.j = "j";
        this.k = "k";
        this.l = "l";
        this.m = "m";
        this.n = "n";
        this.o = "o";
        this.p = "p";
        this.q = "q";
        this.r = "r";
        this.s = "s";
        this.t = "t";
        this.u = "u";
        this.v = "v";
        this.w = "w";
    }
}