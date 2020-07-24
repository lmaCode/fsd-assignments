package com.lipengwei.fsd.feign;

import com.lipengwei.fsd.dto.TUser;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "sba-user", fallback = UserFeignFallback.class)
public interface UserFeign {

    @RequestMapping(value = "/api/user/findByEmail/{email}", method = RequestMethod.GET)
    ResponseEntity<TUser> findByEmail(@PathVariable(name = "email", required = true) String email);
}
