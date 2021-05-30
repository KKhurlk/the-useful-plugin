package com.useful.zyf.dao;

import com.useful.zyf.entity.NowItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NowItemDAO extends JpaRepository<NowItem, Integer> {
}