package com.useful.zyf.service;

import com.useful.zyf.dao.UserDAO;
import com.useful.zyf.dto.UserDTO;
import com.useful.zyf.entity.AdminRole;
import com.useful.zyf.entity.User;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    UserDAO userDAO;
    @Autowired
    AdminRoleService adminRoleService;
    @Autowired
    AdminUserRoleService adminUserRoleService;

    public boolean isExist(String username) {
        User user = getByUserName(username);
        return null!=user;
    }

    public User getByUserName(String username) {
        return userDAO.findByUsername(username);
    }

    public User get(String username, String password){
        return userDAO.getByUsernameAndPassword(username, password);
    }

    public User findByUsername(String username) {
        return userDAO.findByUsername(username);
    }

    public void add(User user) {
        userDAO.save(user);
    }




    public List<UserDTO> list() {
        List<User> users = userDAO.findAll();

        // Find all roles in DB to enable JPA persistence context.
//        List<AdminRole> allRoles = adminRoleService.findAll();

        List<UserDTO> userDTOS = users
                .stream().map(user -> (UserDTO) new UserDTO().convertFrom(user)).collect(Collectors.toList());

        userDTOS.forEach(u -> {
            List<AdminRole> roles = adminRoleService.listRolesByUser(u.getUsername());
            u.setRoles(roles);
        });

        return userDTOS;
    }


    public void editUser(User user) {
        User userInDB = userDAO.findByUsername(user.getUsername());
//        userInDB.setName(user.getName());
//        userInDB.setPhone(user.getPhone());
//        userInDB.setEmail(user.getEmail());
        userDAO.save(userInDB);
        adminUserRoleService.saveRoleChanges(userInDB.getId(), user.getRoles());
    }

    public User resetPassword(User user) {
        User userInDB = userDAO.findByUsername(user.getUsername());
        String salt = new SecureRandomNumberGenerator().nextBytes().toString();
        int times = 2;
        userInDB.setSalt(salt);
        String encodedPassword = new SimpleHash("md5", "123", salt, times).toString();
        userInDB.setPassword(encodedPassword);
        return userDAO.save(userInDB);
    }

    public void updateUserStatus(User user) {
        User userInDB = userDAO.findByUsername(user.getUsername());
        userInDB.setEnabled(user.isEnabled());
        userDAO.save(userInDB);
    }



}