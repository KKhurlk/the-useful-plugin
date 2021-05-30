package com.useful.zyf.controller;

import com.useful.zyf.entity.ItemCategory;
import com.useful.zyf.entity.SuccessItem;
import com.useful.zyf.result.Result;
import com.useful.zyf.result.ResultFactory;
import com.useful.zyf.service.ItemCategoryService;
import com.useful.zyf.service.NowItemService;
import com.useful.zyf.service.SuccessItemService;
import com.useful.zyf.utils.ProcessCombineUtils;
import com.useful.zyf.utils.ProcessCommitsUtils;
import com.useful.zyf.utils.ProcessPullRequestsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
public class GithubController {

    @Autowired
    NowItemService nowItemService;
    @Autowired
    SuccessItemService successItemService;
    @Autowired
    ItemCategoryService itemCategoryService;

    @PostMapping("/api/getgithub")
    public String getKey(@RequestBody Map<String, Object> params) throws Exception {
        ProcessCombineUtils processCombineUtils = new ProcessCombineUtils();
        ProcessPullRequestsUtils processPullRequestsUtils = new ProcessPullRequestsUtils();
        ProcessCommitsUtils processCommitsUtils = new ProcessCommitsUtils();

        /*

        根据项目名和类型，爬取相关数据
         */
        String name = (String) params.get("name");       //要爬取的项目名
        String classname = (String) params.get("classname");  //爬取的类型commits pulls
        String resultclassname;
        String type;
        String web;
        if(classname.equals("github-commits")){
             resultclassname = "commits";
             type = "commits";
        }else if(classname.equals("github-pulls")){
             resultclassname = "pulls";
             type = "pull requests";
        }else {
             resultclassname = "pulls";
             type = "context_prs";
        }
        if(type.equals("commits")){
             web ="https://api.github.com/repos/"+name+"/"+resultclassname+"?&per_page=100&page=";
        }else {
            web ="https://api.github.com/repos/"+name+"/"+resultclassname+"?state=closed&per_page=100&page=";
        }


        if(classname.equals("github-commits")){
//            processCommitsUtils.getGithubCommits(web,name);
        }else if(classname.equals("github-pulls")){
//            processPullRequestsUtils.getGithubPulls(web,name);
        }else{
//            processPullRequestsUtils.getGithubPulls(web,name);   //改动combine
        }

        TimeUnit.HOURS.sleep(5);

        SuccessItem successItem = new SuccessItem();
        successItem.setName(name);
        successItem.setType(type);
        successItemService.addOrUpdate(successItem);     //向success表中添加

        ItemCategory itemCategory = new ItemCategory();   //向item表中添加
        if(itemCategoryService.getname(name) == null){
            itemCategory.setName(name);
        }

        return "success";
    }


    @PostMapping("/api/gethistory")
    public Result getHistoryName(@RequestBody Map<String, Object> params) throws Exception {

        int id =  (Integer)params.get("id");
        ItemCategory itemCategory = new ItemCategory();
        String historyname = itemCategoryService.get(id).getName();

        return ResultFactory.buildSuccessResult(historyname);

    }

}
