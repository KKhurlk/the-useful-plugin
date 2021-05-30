package com.useful.zyf.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "artifactdefine")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class ArtifactDefine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;

    @ManyToOne
    @JoinColumn(name="cid")
    private ItemCategory itemcategory;

    String artifactone;
    String artifacttwo;
    String path;
    String status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ItemCategory getItemcategory() {
        return itemcategory;
    }

    public void setItemcategory(ItemCategory itemcategory) {
        this.itemcategory = itemcategory;
    }

    public String getArtifactone() {
        return artifactone;
    }

    public void setArtifactone(String artifact_one) {
        this.artifactone = artifact_one;
    }

    public String getArtifacttwo() {
        return artifacttwo;
    }

    public void setArtifacttwo(String artifact_two) {
        this.artifacttwo = artifact_two;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


//    public int getCid() {
//        return cid;
//    }
//
//    public void setCid(int cid) {
//        this.cid = cid;
//    }


}
