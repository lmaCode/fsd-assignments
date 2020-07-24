package com.lipengwei.fsd.service;

import com.lipengwei.fsd.entity.SysUser;

public interface UserService  {

     SysUser loadUserByUsername(String username);

    void updateUser(SysUser sysUser);

    void register(SysUser sysUser);
}
