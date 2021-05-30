package com.useful.zyf.controller;

import com.useful.zyf.entity.Artifact;
import com.useful.zyf.result.Result;
import com.useful.zyf.result.ResultFactory;
import com.useful.zyf.service.ArtifactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;


@RestController
public class ArtifactController {

    @Autowired
    ArtifactService artifactService;

    @GetMapping("/api/artifacts")
    public Result list() throws Exception {
        return ResultFactory.buildSuccessResult(artifactService.list());
    }


//    @PostMapping("/api/artifacts")
//    public Artifact addOrUpdate(@RequestBody Artifact artifact) throws Exception {
//
//        artifactService.addOrUpdate(artifact);
//        return artifact;
//    }
//
//    @PostMapping("/api/delete/artifact")
//    public void delete(@RequestBody Artifact artifact) throws Exception {
//        artifactService.deleteById(artifact.getId());
//    }

    @PostMapping("/api/admin/content/artifacts")
    public Result addOrUpdate(@RequestBody Artifact artifact) throws Exception {

        artifactService.addOrUpdate(artifact);
        return ResultFactory.buildSuccessResult("修改成功");
    }

    @PostMapping("/api/admin/content/artifacts/delete")
    public Result delete(@RequestBody @Valid Artifact artifact) throws Exception {
        artifactService.deleteById(artifact.getId());
        return ResultFactory.buildSuccessResult("删除成功");
    }


    @GetMapping("/api/itemcategories/{cid}/artifacts")
    public Result listByCategory(@PathVariable("cid") int cid) throws Exception {
        if (0 != cid) {
            return ResultFactory.buildSuccessResult(artifactService.listByCategory(cid));
        } else {
            return ResultFactory.buildSuccessResult(artifactService.list());
        }
    }

    @GetMapping("/api/itemcategories/{cid}/artifacts/{type}")
    public Result listByCategoryAndType(@PathVariable("cid") int cid, @PathVariable("type") String type) throws Exception {
        if (!type.equals("all")) {
            return ResultFactory.buildSuccessResult(artifactService.listByCategoryAndType(cid,type));
        } else {
            return ResultFactory.buildSuccessResult(artifactService.listByCategory(cid));
        }
    }

    @CrossOrigin
    @GetMapping("/api/search/artifact")
    public Result searchResult(@RequestParam("keywords") String keywords) {
        // 关键词为空时查询出所有文件
        if ("".equals(keywords)) {
            return ResultFactory.buildSuccessResult(artifactService.list());
        } else {
            return ResultFactory.buildSuccessResult(artifactService.search(keywords));
        }
    }

}

