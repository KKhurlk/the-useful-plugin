package com.useful.zyf.dao;

import com.useful.zyf.entity.ArtifactDefine;
import com.useful.zyf.entity.ItemCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ArtifactDefineDAO extends JpaRepository<ArtifactDefine,Integer> {

    List<ArtifactDefine> findAllByItemcategory(ItemCategory itemcategory);

    List<ArtifactDefine> findAllByArtifactoneLikeOrArtifacttwoLike(String keyword1,String keyword2);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "update artifactdefine p set p.status =?1 where p.id = ?2",nativeQuery = true)
    int updateStatusById( String status,  int id);

//    List<Artifact> findAllByItemcategoryAndType(ItemCategory itemcategory,String type);

}
