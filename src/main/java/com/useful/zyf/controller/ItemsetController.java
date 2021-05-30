package com.useful.zyf.controller;

import com.useful.zyf.entity.File;
import com.useful.zyf.result.Result;
import com.useful.zyf.result.ResultFactory;
import com.useful.zyf.service.FileService;
import com.useful.zyf.utils.StringUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;

@RestController
public class ItemsetController {

    @Autowired
    FileService fileService;

    @GetMapping("/api/files")
    public Result listBooks() {
        return ResultFactory.buildSuccessResult(fileService.list());
    }

//    @PostMapping("/api/files")
//    public File addOrUpdate(@RequestBody File file) throws Exception {
//        fileService.addOrUpdate(file);
//        return file;
//    }
//
//    @PostMapping("/api/delete/file")
//    public void delete(@RequestBody File file) throws Exception {
//        fileService.deleteById(file.getId());
//    }

    @PostMapping("/api/admin/content/files")
    public Result addOrUpdateBooks(@RequestBody @Valid File file) {
        fileService.addOrUpdate(file);
        return ResultFactory.buildSuccessResult("修改成功");
    }

    @PostMapping("/api/admin/content/files/delete")
    public Result deleteBook(@RequestBody @Valid File file) {
        fileService.deleteById(file.getId());
        return ResultFactory.buildSuccessResult("删除成功");
    }


    @GetMapping("/api/itemcategories/{cid}/files")
    public Result listByCategory(@PathVariable("cid") int cid) throws Exception {
        if (0 != cid) {
            return ResultFactory.buildSuccessResult(fileService.listByCategory(cid));
        } else {
            return ResultFactory.buildSuccessResult(fileService.list());
        }
    }

    @CrossOrigin
    @GetMapping("/api/search/file")
    public Result searchResult(@RequestParam("keywords") String keywords) {
        // 关键词为空时查询出所有文件
        if ("".equals(keywords)) {
            return ResultFactory.buildSuccessResult(fileService.list());
        } else {
            return ResultFactory.buildSuccessResult(fileService.search(keywords));
        }
    }


    @CrossOrigin
    @PostMapping("api/paths")
    public String fileUpload(MultipartFile file) throws Exception {
        String folder = "D:/毕设相关/workspace/file";
        java.io.File pathFolder = new java.io.File(folder);
        java.io.File f = new java.io.File(pathFolder, StringUtils.getRandomString(6) + "." + FilenameUtils.getExtension(file.getOriginalFilename()));
        if (!f.getParentFile().exists())
            f.getParentFile().mkdirs();
        try {
            file.transferTo(f);
            String fileURL = "http://localhost:8443/api/file/" + f.getName();
            return fileURL;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

}


