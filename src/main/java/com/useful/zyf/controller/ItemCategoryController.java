package com.useful.zyf.controller;

import com.useful.zyf.entity.ItemCategory;
import com.useful.zyf.result.Result;
import com.useful.zyf.result.ResultFactory;
import com.useful.zyf.service.ItemCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ItemCategoryController {

    @Autowired
    ItemCategoryService itemCategoryService;

    @GetMapping("/api/names")
    public Result listNames() {
        return ResultFactory.buildSuccessResult(itemCategoryService.list());
    }

    @PostMapping("/api/names")
    public Result addOrUpdate(@RequestBody ItemCategory itemCategory) throws Exception {
        itemCategoryService.addOrUpdate(itemCategory);
        return ResultFactory.buildSuccessResult("修改成功");
    }

}
