package com.lipengwei.fsd.service.impl;

import com.lipengwei.fsd.dto.TTraining;
import com.lipengwei.fsd.feign.TrainingFeign;
import com.lipengwei.fsd.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    private TrainingFeign trainingFeign;

    @Override
    public List<TTraining> findAllCourse() {
        return trainingFeign.findAllCourse().getBody();
    }
}
