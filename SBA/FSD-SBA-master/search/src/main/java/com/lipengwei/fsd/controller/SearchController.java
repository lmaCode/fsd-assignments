package com.lipengwei.fsd.controller;

import com.lipengwei.fsd.dto.TTraining;
import com.lipengwei.fsd.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/search")
public class SearchController {
    @Autowired
    private SearchService searchService;

    @GetMapping("/course/list")
    public ResponseEntity<List<TTraining>> findAllCourse(){
        List<TTraining> allCourse = searchService.findAllCourse();
        return ResponseEntity.ok(allCourse);
    }
}
