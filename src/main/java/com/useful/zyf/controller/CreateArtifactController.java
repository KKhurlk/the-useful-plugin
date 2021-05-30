package com.useful.zyf.controller;

import com.useful.zyf.github.src.GithubMain;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class CreateArtifactController {

    @PostMapping("/api/createartifact")
    public String createArtifact(@RequestBody Map<String, Object> params) throws Exception {
        GithubMain processArtifact = new GithubMain();

        String name = (String) params.get("name");       //项目名
        String type = (String) params.get("type");  //类型

        processArtifact.artifactCreateMethod(name,type);    //生成制品推荐

        return "success";
    }
}
