package com.useful.zyf.dao;

import com.useful.zyf.entity.AdminRole;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 */
public interface AdminRoleDAO extends JpaRepository<AdminRole, Integer> {
    AdminRole findById(int id);
}
