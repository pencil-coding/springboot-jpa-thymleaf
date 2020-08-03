package com.offcn.dao;

import com.offcn.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDao extends JpaRepository<User,Long> {

    //根据用户名查找
    public List<User> findByUnameIs(String uname);
}
