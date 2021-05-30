package com.useful.zyf.dao;

import com.useful.zyf.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User,Integer> {
    User findByUsername(String username);

    User getByUsernameAndPassword(String username,String password);

//    @Query(value = "select new com.useful.zyf.entity.User(id,username) from com.useful.zyf.entity.User user")
//    List<User> findAllById(int id);

//    @Query(value = "select new User(u.id,u.username,u.enabled) from User u")
//    List<User> list();
}
