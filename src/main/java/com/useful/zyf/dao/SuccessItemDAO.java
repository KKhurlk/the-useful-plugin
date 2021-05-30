package com.useful.zyf.dao;

import com.useful.zyf.entity.SuccessItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SuccessItemDAO extends JpaRepository<SuccessItem, Integer> {
    SuccessItem findByName(String name);
}
