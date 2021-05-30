package com.useful.zyf.controller;

import cn.hutool.http.HttpUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserControllerTest {
    @Autowired
    private UserController userController;

    @Test
    public void userResult() {
        System.out.println("ok");
        String s = HttpUtil.get("http://localhost:8443/api//admin/user");

//        String s1 = HttpUtil.get("http://localhost:8443/api/logout");
        System.out.println(s);
//        System.out.println(s1);
    }

}