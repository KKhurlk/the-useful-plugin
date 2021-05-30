package com.useful.zyf.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "artifact")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class Artifact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;

    @ManyToOne
    @JoinColumn(name="cid")
    private ItemCategory itemcategory;

    String artifactone;
    String artifacttwo;
    String support;
    String type;

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

    public String getSupport() {
        return support;
    }

    public void setSupport(String support) {
        this.support = support;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

//    public int getCid() {
//        return cid;
//    }
//
//    public void setCid(int cid) {
//        this.cid = cid;
//    }


}
