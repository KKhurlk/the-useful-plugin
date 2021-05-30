package com.useful.zyf.service;

import com.useful.zyf.dao.NowItemDAO;
import com.useful.zyf.entity.NowItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NowItemService {
    @Autowired
    NowItemDAO nowItemDAO;

    public List<NowItem> list() {
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        return nowItemDAO.findAll(sort);
    }

    public NowItem get(int id) {
        NowItem c= nowItemDAO.findById(id).orElse(null);
        return c;
    }

    public void addOrUpdate(NowItem nowItem) {
        nowItemDAO.save(nowItem);
    }
    public void deleteById(int id) {
        nowItemDAO.deleteById(id);
    }

}