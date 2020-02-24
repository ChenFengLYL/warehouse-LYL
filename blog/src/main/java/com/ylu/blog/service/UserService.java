package com.ylu.blog.service;

import com.ylu.blog.po.User;

public interface UserService {
    public User checkUser(String username, String password);
}
