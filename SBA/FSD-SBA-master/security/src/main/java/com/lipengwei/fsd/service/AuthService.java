package com.lipengwei.fsd.service;

import com.lipengwei.fsd.dto.TUser;
import com.lipengwei.fsd.dto.UserInfoDto;

public interface AuthService {
    void register(TUser registerUser);

    UserInfoDto checkToken(String token);
}
