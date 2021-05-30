package com.useful.zyf.service;

import com.useful.zyf.dao.ItemCategoryDAO;
import com.useful.zyf.entity.ItemCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemCategoryService {
    @Autowired
    ItemCategoryDAO itemCategoryDAO;

    public List<ItemCategory> list() {
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        return itemCategoryDAO.findAll(sort);
    }

    public ItemCategory get(int id) {
        ItemCategory c= itemCategoryDAO.findById(id).orElse(null);
        return c;
    }

    public ItemCategory getname(String name){
        ItemCategory d= itemCategoryDAO.findByName(name);
        return d;
    }

    public void addOrUpdate(ItemCategory itemCategory) {
        itemCategoryDAO.save(itemCategory);
    }
    public void deleteById(int id) {
        itemCategoryDAO.deleteById(id);
    }

}