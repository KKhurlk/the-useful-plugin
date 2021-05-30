package com.useful.zyf.controller;

import com.useful.zyf.entity.NowItem;
import com.useful.zyf.result.Result;
import com.useful.zyf.result.ResultFactory;
import com.useful.zyf.service.ArtifactService;
import com.useful.zyf.service.ItemCategoryService;
import com.useful.zyf.service.NowItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Map;


@RestController
public class NowItemController {

    @Autowired
    NowItemService nowItemService;

    @Autowired
    ArtifactService artifactService;

    @Autowired
    ItemCategoryService itemCategoryService;

    @GetMapping("/api/nowitem")
    public Result listNames() {
        return ResultFactory.buildSuccessResult(nowItemService.list());
    }

    @PostMapping("/api/cancel")
    public Result delete(@RequestBody @Valid NowItem nowItem) throws Exception {
        nowItemService.deleteById(nowItem.getId());
        return ResultFactory.buildSuccessResult("删除成功");
    }

    @PostMapping("/api/addtonowitem")
    public String getKey(@RequestBody Map<String, Object> params) throws Exception {

        String name = (String) params.get("name");       //要爬取的项目名
        String classname = (String) params.get("classname");  //爬取的类型commits pulls
        String type;
        if(classname.equals("github-commits")){
            type = "commits";
        }else if(classname.equals("github-pulls")){
            type = "pull requests";
        }else {
            type = "context_prs";
        }


        NowItem nowItem = new NowItem();
        nowItem.setName(name);
        nowItem.setType(type);
        nowItemService.addOrUpdate(nowItem);

/*
存入数据库
 */
//        String namename ="spring-projects/spring-boot";
//        String typetype = "context_prs";
//
//
//        String path = "C:/Users/dell/Desktop/springboot-context_prs.txt";
//        File file = new File(path);
//        BufferedReader reader;
//        reader = new BufferedReader(new FileReader(file));
//        String tempStr;
//        BufferedWriter bw = null;
//        while ((tempStr = reader.readLine()) != null) {
//            if(tempStr.contains("java")){
//                Artifact artifact = new Artifact();
//                String[] artifact_str = tempStr.split("  ,  ");
//                artifact.setArtifactone(artifact_str[0]);
//                artifact.setArtifacttwo(artifact_str[1]);
//
//                String sup=artifact_str[2].substring(artifact_str[2].indexOf(":")+1);
//                artifact.setSupport(sup+1);
//
//                ItemCategory itemcategory = itemCategoryService.getname(namename);
//
//                artifact.setItemcategory(itemcategory);
//                artifact.setType(typetype);
//                artifactService.addOrUpdate(artifact);
//            }
//        }
//        System.out.println("我要飞翔");



        return "success";
    }

}
