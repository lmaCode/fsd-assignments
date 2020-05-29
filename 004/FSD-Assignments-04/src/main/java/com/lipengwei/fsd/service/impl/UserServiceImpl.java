package com.lipengwei.fsd.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lipengwei.fsd.entity.SysUser;
import com.lipengwei.fsd.mapper.UserMapper;
import com.lipengwei.fsd.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public SysUser loadUserByUsername(String username) {
        return userMapper.findByUsername(username);
    }

    @Override
    public void updateUser(SysUser sysUser) {
        userMapper.update(sysUser);
    }

    @Override
    public void register(SysUser sysUser) {
        sysUser.setRole("ROLE_user");
        userMapper.insert(sysUser);
    }

}
