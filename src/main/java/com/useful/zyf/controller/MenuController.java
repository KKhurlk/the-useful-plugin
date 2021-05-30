package com.useful.zyf.controller;

import com.useful.zyf.entity.AdminMenu;
import com.useful.zyf.result.Result;
import com.useful.zyf.result.ResultFactory;
import com.useful.zyf.service.AdminMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Menu controller.
 */
@RestController
public class MenuController {
    @Autowired
    AdminMenuService adminMenuService;

//    @GetMapping("/api/menu")
//    public Result menu() {
//        return ResultFactory.buildSuccessResult(adminMenuService.getMenusByCurrentUser());
//    }

    @GetMapping("/api/menu")
    public List<AdminMenu> menu() {
        return adminMenuService.getMenusByCurrentUser();
    }

    @GetMapping("/api/admin/role/menu")
    public Result listAllMenus() {
        return ResultFactory.buildSuccessResult(adminMenuService.getMenusByRoleId(1));
    }


}
