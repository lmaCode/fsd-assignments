package com.lipengwei.fsd.feign;

import com.lipengwei.fsd.dto.TTechnology;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "sba-technology", fallback = TechnologyFeignFallback.class)
public interface TechnologyFeign {

    @RequestMapping(value = "/api/technology/find/{skillId}", method = RequestMethod.GET)
    ResponseEntity<TTechnology> findBySkillId(@PathVariable("skillId") String skillId);
}
