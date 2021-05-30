package com.useful.zyf.controller;

import cn.hutool.http.HttpUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ItemsetControllerTest {

    @Autowired
    private ItemsetController itemsetController;
    @Test
    void searchResult() {
        System.out.println("ok");
        String s = HttpUtil.get("http://localhost:8443/api/search?keywords=maven");

        String s1 = HttpUtil.get("http://localhost:8443/api/logout");
        System.out.println(s);
        System.out.println(s1);
    }
}