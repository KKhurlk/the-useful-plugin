package com.useful.zyf.dao;

import com.useful.zyf.entity.File;
import com.useful.zyf.entity.ItemCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FileDAO extends JpaRepository<File,Integer> {

    List<File> findAllByItemcategory(ItemCategory itemcategory);

    List<File> findAllByFilenameLike(String keyword1);
}