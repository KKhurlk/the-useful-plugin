package com.useful.zyf.controller;

import com.useful.zyf.entity.ArtifactDefine;
import com.useful.zyf.result.Result;
import com.useful.zyf.result.ResultFactory;
import com.useful.zyf.service.ArtifactDefineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class ArtifactDefineController {

    @Autowired
    ArtifactDefineService artifactDefineService;

    @GetMapping("/api/defineartifacts")
    public Result list() throws Exception {
        return ResultFactory.buildSuccessResult(artifactDefineService.list());
    }

    @PostMapping("/api/defineartifacts")
    public ArtifactDefine addOrUpdate(@RequestBody ArtifactDefine artifactDefine) throws Exception {


        System.out.println(artifactDefine.getArtifactone());
        System.out.println(artifactDefine.getPath());
        artifactDefine.setStatus("未审核");
        artifactDefineService.addOrUpdate(artifactDefine);
        return artifactDefine;
    }

    @GetMapping("/api/itemcategories/{cid}/artifactsdefine")
    public Result listByCategory(@PathVariable("cid") int cid) throws Exception {
        if (0 != cid) {
            return ResultFactory.buildSuccessResult(artifactDefineService.listByCategory(cid));
        } else {
            return ResultFactory.buildSuccessResult(artifactDefineService.list());
        }
    }

    @PostMapping("/api/admin/content/defineyes")
    public Result updateStatusById(@RequestBody @Valid ArtifactDefine artifactDefine) throws Exception {

        String status ="已审核";
        int id = artifactDefine.getId();
        artifactDefineService.updateStatusById(status,id);
        return ResultFactory.buildSuccessResult("修改成功");
    }


    @PostMapping("/api/admin/content/defineartifacts/delete")
    public Result delete(@RequestBody @Valid ArtifactDefine artifactDefine) throws Exception {
        artifactDefineService.deleteById(artifactDefine.getId());
        return ResultFactory.buildSuccessResult("删除成功");
    }
}
