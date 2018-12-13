package com.xjtu.service;

import com.xjtu.mapper.UserMapper;
import com.xjtu.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public User queryById(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    public List<User> queryList() {
        return userMapper.selectAll();
    }

    @Transactional  //事务
    public void insertUser(User user) {
        userMapper.insert(user);
    }
}
