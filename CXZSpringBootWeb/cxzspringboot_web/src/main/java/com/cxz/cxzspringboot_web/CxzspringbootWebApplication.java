package com.cxz.cxzspringboot_web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication

//@ServletComponentScan
public class CxzspringbootWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(CxzspringbootWebApplication.class, args);
    }

}
