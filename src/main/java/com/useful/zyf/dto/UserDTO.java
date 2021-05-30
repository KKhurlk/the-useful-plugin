package com.useful.zyf.dto;

import com.useful.zyf.dto.base.OutputConverter;
import com.useful.zyf.entity.AdminRole;
import com.useful.zyf.entity.User;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 */
@Data
@ToString
public class UserDTO implements OutputConverter<UserDTO, User> {

    private int id;

    private String username;

//    private String name;
//
//    private String phone;
//
//    private String email;
//
    private boolean enabled;

    private List<AdminRole> roles;

}
