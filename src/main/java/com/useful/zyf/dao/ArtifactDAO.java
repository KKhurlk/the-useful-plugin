package com.useful.zyf.dao;

import com.useful.zyf.entity.Artifact;
import com.useful.zyf.entity.ItemCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArtifactDAO extends JpaRepository<Artifact,Integer> {

    List<Artifact> findAllByItemcategory(ItemCategory itemcategory);

    List<Artifact> findAllByArtifactoneLikeOrArtifacttwoLike(String keyword1,String keyword2);

    List<Artifact> findAllByItemcategoryAndType(ItemCategory itemcategory,String type);
}
