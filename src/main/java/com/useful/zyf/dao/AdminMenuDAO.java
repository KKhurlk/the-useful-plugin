package com.useful.zyf.dao;

import com.useful.zyf.entity.AdminMenu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 */
public interface AdminMenuDAO extends JpaRepository<AdminMenu, Integer> {
    AdminMenu findById(int id);
    List<AdminMenu> findAllByParentId(int parentId);
}

