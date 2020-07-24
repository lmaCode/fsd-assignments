package com.lipengwei.fsd.feign;

import com.lipengwei.fsd.dto.TTraining;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "sba-training", fallback = TrainingFeignFallback.class)
public interface TrainingFeign {

    @RequestMapping(value = "/api/training/list", method = RequestMethod.GET)
    ResponseEntity<List<TTraining>> findAllCourse();
}
