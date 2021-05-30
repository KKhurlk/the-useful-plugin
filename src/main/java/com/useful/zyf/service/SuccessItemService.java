package com.useful.zyf.service;

import com.useful.zyf.dao.SuccessItemDAO;
import com.useful.zyf.entity.SuccessItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuccessItemService {

    @Autowired
    SuccessItemDAO successItemDAO;

    public List<SuccessItem> list() {
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        return successItemDAO.findAll(sort);
    }

    public SuccessItem get(int id) {
        SuccessItem c= successItemDAO.findById(id).orElse(null);
        return c;
    }

    public SuccessItem getname(String name){
        SuccessItem d= successItemDAO.findByName(name);
        return d;
    }

    public void addOrUpdate(SuccessItem successItem) {
        successItemDAO.save(successItem);
    }
    public void deleteById(int id) {
        successItemDAO.deleteById(id);
    }
}
