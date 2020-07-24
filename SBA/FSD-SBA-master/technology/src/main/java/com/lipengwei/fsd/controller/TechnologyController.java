package com.lipengwei.fsd.controller;

import com.lipengwei.fsd.entity.TTechnology;
import com.lipengwei.fsd.service.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/technology")
public class TechnologyController {
    @Autowired
    private TechnologyService technologyService;

    @GetMapping("/list")
    public ResponseEntity<List<TTechnology>> list(){
        List<TTechnology> technologies = technologyService.findAllTechnologies();
        return ResponseEntity.ok(technologies);
    }

    @GetMapping("/find/{skillId}")
    public ResponseEntity<TTechnology> find(@PathVariable("skillId") String skillId){
        TTechnology technology = technologyService.findBySkillId(skillId);
        return ResponseEntity.ok(technology);
    }
}
