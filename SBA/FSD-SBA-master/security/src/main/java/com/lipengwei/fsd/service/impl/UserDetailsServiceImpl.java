package com.lipengwei.fsd.service.impl;

import com.lipengwei.fsd.dto.JwtUser;
import com.lipengwei.fsd.dto.TUser;
import com.lipengwei.fsd.dto.User;
import com.lipengwei.fsd.feign.UserFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserFeign userFeign;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ResponseEntity<TUser> responseEntity = userFeign.findByEmail(username);
        TUser tUser = responseEntity.getBody();
        User user = new User();
        user.setRole(tUser.getRole());
        user.setUsername(tUser.getEmail());
        user.setPassword(tUser.getPwd());
        user.setId(tUser.getId());
        return new JwtUser(user);
    }

}
