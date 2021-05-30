package com.useful.zyf.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

/**
 * Relations between roles and permissions.
 *
 */
@Data
@Entity
@Table(name = "admin_role_permission")
@ToString
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
public class AdminRolePermission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    /**
     * Role id.
     */
    private int rid;

    /**
     * Permission id.
     */
    private int pid;
}
