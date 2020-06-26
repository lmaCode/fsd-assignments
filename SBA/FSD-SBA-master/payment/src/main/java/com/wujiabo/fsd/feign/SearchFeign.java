package com.lipengwei.fsd.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "sba-search", fallback = SearchFeignFallback.class)
public interface SearchFeign {

    @RequestMapping(value = "/testSearch", method = RequestMethod.GET)
    String testSearch();
}
