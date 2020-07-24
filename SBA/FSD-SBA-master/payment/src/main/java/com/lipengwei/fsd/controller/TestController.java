package com.lipengwei.fsd.controller;

import com.lipengwei.fsd.feign.SearchFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Value("${server.port}")
    String port;

    @Autowired
    private SearchFeign searchFeign;

    @GetMapping("/")
    public String home() {
        return "Hello world ,port:" + port;
    }
}
