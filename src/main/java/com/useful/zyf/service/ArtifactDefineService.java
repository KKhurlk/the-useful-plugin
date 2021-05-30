package com.useful.zyf.service;

import com.useful.zyf.dao.ArtifactDefineDAO;
import com.useful.zyf.entity.ArtifactDefine;
import com.useful.zyf.entity.ItemCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtifactDefineService {
    @Autowired
    ArtifactDefineDAO artifactDefineDAO;
    @Autowired
    ItemCategoryService itemCategoryService;

    public List<ArtifactDefine> list() {
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        return artifactDefineDAO.findAll(sort);
    }

    public void addOrUpdate(ArtifactDefine artifactDefine) {
        artifactDefineDAO.save(artifactDefine);
    }

    public void deleteById(int id) {
        artifactDefineDAO.deleteById(id);
    }


    public List<ArtifactDefine> listByCategory(int cid) {
        ItemCategory itemcategory = itemCategoryService.get(cid);
        return artifactDefineDAO.findAllByItemcategory(itemcategory);
    }

    public void updateStatusById( String status,  int id){
        artifactDefineDAO.updateStatusById(status, id);
    }

//    public List<Artifact> listByCategoryAndType(int cid,String type){
//        ItemCategory itemcategory = itemCategoryService.get(cid);
//        return artifactDefineDAO.findAllByItemcategoryAndType(itemcategory,type);
//    }

    public List<ArtifactDefine> search(String keywords) {
        return artifactDefineDAO.findAllByArtifactoneLikeOrArtifacttwoLike('%' + keywords + '%', '%' + keywords + '%');
    }
}