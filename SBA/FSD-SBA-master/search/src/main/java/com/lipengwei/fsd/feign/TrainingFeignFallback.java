package com.lipengwei.fsd.feign;

import com.lipengwei.fsd.dto.TTraining;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TrainingFeignFallback implements TrainingFeign {
    @Override
    public ResponseEntity<List<TTraining>> findAllCourse() {
        return null;
    }
}
