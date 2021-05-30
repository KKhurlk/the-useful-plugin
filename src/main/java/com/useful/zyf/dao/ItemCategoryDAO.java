package com.useful.zyf.dao;

import com.useful.zyf.entity.ItemCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemCategoryDAO extends JpaRepository<ItemCategory, Integer> {


    ItemCategory findByName(String name);


}