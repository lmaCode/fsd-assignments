package com.lipengwei.fsd.service.impl;

import com.lipengwei.fsd.dto.TUser;
import com.lipengwei.fsd.dto.UserInfoDto;
import com.lipengwei.fsd.exception.TokenIsExpiredException;
import com.lipengwei.fsd.feign.UserFeign;
import com.lipengwei.fsd.service.AuthService;
import com.lipengwei.fsd.utils.JwtTokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private UserFeign userFeign;
    @Override
    public void register(TUser registerUser) {
        registerUser.setPwd(bCryptPasswordEncoder.encode(registerUser.getPwd()));
        userFeign.save(registerUser);
    }

    @Override
    public UserInfoDto checkToken(String token) {
        token = token.replace(JwtTokenUtils.TOKEN_PREFIX, "");
        if(JwtTokenUtils.isExpiration(token)){
            throw new TokenIsExpiredException("token超时了");
        }
        String username = JwtTokenUtils.getUsername(token);
        String role = JwtTokenUtils.getUserRole(token);
        UserInfoDto userInfoDto = new UserInfoDto();
        userInfoDto.setUsername(username);
        userInfoDto.setRole(role);
        return userInfoDto;
    }
}
