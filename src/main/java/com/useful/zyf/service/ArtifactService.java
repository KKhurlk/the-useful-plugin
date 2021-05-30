package com.useful.zyf.service;

import com.useful.zyf.dao.ArtifactDAO;
import com.useful.zyf.entity.Artifact;
import com.useful.zyf.entity.ItemCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtifactService {
    @Autowired
    ArtifactDAO artifactDAO;
    @Autowired
    ItemCategoryService itemCategoryService;

    public List<Artifact> list() {
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        return artifactDAO.findAll(sort);
    }

    public void addOrUpdate(Artifact artifact) {
        artifactDAO.save(artifact);
    }

    public void deleteById(int id) {
        artifactDAO.deleteById(id);
    }

    public List<Artifact> listByCategory(int cid) {
        ItemCategory itemcategory = itemCategoryService.get(cid);
        return artifactDAO.findAllByItemcategory(itemcategory);
    }

    public List<Artifact> listByCategoryAndType(int cid,String type){
        ItemCategory itemcategory = itemCategoryService.get(cid);
        return artifactDAO.findAllByItemcategoryAndType(itemcategory,type);
    }

    public List<Artifact> search(String keywords) {
        return artifactDAO.findAllByArtifactoneLikeOrArtifacttwoLike('%' + keywords + '%', '%' + keywords + '%');
    }
}