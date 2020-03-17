package com.ylu.warehouse.sys.service.impl;

import com.ylu.warehouse.sys.domain.User;
import com.ylu.warehouse.sys.mapper.UserMapper;
import com.ylu.warehouse.sys.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 李远亮
 * @since 2020-03-16
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
