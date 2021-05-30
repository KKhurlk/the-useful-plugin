package com.useful.zyf.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "successitem")
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })

public class SuccessItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;

    String name;
    String type;
    String submitter;
    String status;
    int pair;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public String getSubmitter() {
        return submitter;
    }
    public void setSubmitter(String submitter) {
        this.submitter = submitter;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public int getPair() {
        return pair;
    }
    public void setPair(int pair) {
        this.pair = pair;
    }
}
