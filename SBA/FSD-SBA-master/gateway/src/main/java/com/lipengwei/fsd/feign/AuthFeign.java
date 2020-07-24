package com.lipengwei.fsd.feign;

import com.lipengwei.fsd.dto.UserInfoDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "sba-security", fallback = AuthFeignFallback.class)
public interface AuthFeign {

    @RequestMapping(value = "/api/auth/checkToken", method = RequestMethod.POST)
    ResponseEntity<UserInfoDto> checkToken(@RequestParam("token") String token);
}
