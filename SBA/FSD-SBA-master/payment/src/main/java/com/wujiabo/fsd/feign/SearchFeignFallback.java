package com.lipengwei.fsd.feign;

import org.springframework.stereotype.Component;

@Component
public class SearchFeignFallback implements SearchFeign {
    @Override
    public String testSearch() {
        return null;
    }
}
