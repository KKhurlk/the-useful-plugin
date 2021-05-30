package com.useful.zyf;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.useful.zyf.dao")
public class ZyfApplication {

    public static void main(String[] args) {
        SpringApplication.  run(ZyfApplication.class, args);
    }

}
