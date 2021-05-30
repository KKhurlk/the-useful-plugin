package com.useful.zyf.service;

import com.useful.zyf.dao.FileDAO;
import com.useful.zyf.entity.File;
import com.useful.zyf.entity.ItemCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FileService {
    @Autowired
    FileDAO fileDAO;
    @Autowired
    ItemCategoryService itemCategoryService;

    public List<File> list() {
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        return fileDAO.findAll(sort);
    }

    public void addOrUpdate(File file) {
        fileDAO.save(file);
    }

    public void deleteById(int id) {
        fileDAO.deleteById(id);
    }

    public List<File> listByCategory(int cid) {
        ItemCategory itemcategory = itemCategoryService.get(cid);
        return fileDAO.findAllByItemcategory(itemcategory);
    }

    public List<File> search(String keywords) {
        return fileDAO.findAllByFilenameLike('%' + keywords + '%');
    }

}