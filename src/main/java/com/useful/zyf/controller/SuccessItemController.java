package com.useful.zyf.controller;


import com.useful.zyf.entity.SuccessItem;
import com.useful.zyf.result.Result;
import com.useful.zyf.result.ResultFactory;
import com.useful.zyf.service.SuccessItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class SuccessItemController {

    @Autowired
    SuccessItemService successItemService;

    @PostMapping("/api/deletesuccesswork")
    public Result delete(@RequestBody @Valid SuccessItem successItem) throws Exception {
        successItemService.deleteById(successItem.getId());
        return ResultFactory.buildSuccessResult("删除成功");
    }

    @GetMapping("/api/successnames")
    public Result listNames() {
        return ResultFactory.buildSuccessResult(successItemService.list());
    }
}
