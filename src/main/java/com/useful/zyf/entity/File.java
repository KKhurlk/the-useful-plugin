package com.useful.zyf.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "file")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class File {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;

    String filename;
    String ext;
    String path;
    String size;
    String type;
    String isimg;
    int downcounts;
    String uploadtime;

    @ManyToOne
    @JoinColumn(name="cid")
    private ItemCategory itemcategory;

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

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIsimg() {
        return isimg;
    }

    public void setIsimg(String isimg) {
        this.isimg = isimg;
    }

    public int getDowncounts() {
        return downcounts;
    }

    public void setDowncounts(int downcounts) {
        this.downcounts = downcounts;
    }

    public String getUploadtime() {
        return uploadtime;
    }

    public void setUploadtime(String uploadtime) {
        this.uploadtime = uploadtime;
    }
}
