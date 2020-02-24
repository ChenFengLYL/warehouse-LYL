package com.ylu.blog.service.impl;

import com.ylu.blog.dao.UserRepository;
import com.ylu.blog.po.User;
import com.ylu.blog.service.UserService;
import com.ylu.blog.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public User checkUser(String username, String password) {
        User user = userRepository.findByUsernameAndPassword(username, MD5Utils.code(password));
        return user;
    }
}
