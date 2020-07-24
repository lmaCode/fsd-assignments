package com.lipengwei.fsd.service;

import com.lipengwei.fsd.entity.TUser;

import java.util.List;

public interface UserService {
    List<TUser> findAll();

    TUser findByEmail(String email);

    void save(TUser tUser);
}
