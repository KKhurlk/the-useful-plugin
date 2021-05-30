package com.useful.zyf.service;

import com.alibaba.fastjson.JSON;
import com.useful.zyf.entity.File;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FileServiceTest {
    @Autowired
    private FileService fileService;
    
    @Test
    void listByCategory() {

    }

    @Test
    void search() {
        List<File> search = fileService.search("");
        System.out.println(JSON.toJSON(search));

    }
}