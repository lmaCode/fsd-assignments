package com.lipengwei.fsd.feign;

import com.lipengwei.fsd.dto.TUser;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class UserFeignFallback implements UserFeign {
    @Override
    public ResponseEntity<TUser> findByEmail(String email) {
        return null;
    }
}
