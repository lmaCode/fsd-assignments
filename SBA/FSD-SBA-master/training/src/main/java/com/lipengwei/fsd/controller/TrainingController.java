package com.lipengwei.fsd.controller;

import com.lipengwei.fsd.entity.TTraining;
import com.lipengwei.fsd.service.TrainingService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/training")
public class TrainingController {
    @Autowired
    private TrainingService trainingService;

    @GetMapping("/list")
    public ResponseEntity<List<TTraining>> findAllCourse() {
        List<TTraining> trainings = trainingService.findAllTrainings();
        return ResponseEntity.ok(trainings);
    }

    @GetMapping("/enable/list")
    public ResponseEntity<List<TTraining>> findEnableTrainings() {
        List<TTraining> trainings = trainingService.findEnableTrainings();
        return ResponseEntity.ok(trainings);
    }

    @GetMapping("/my/list/{type}/{status}/{email}")
    public ResponseEntity<List<TTraining>> findMyTrainings(@PathVariable("type") String type,
            @PathVariable("status") String status, @PathVariable("email") String email) {
        List<TTraining> trainings = new ArrayList<>();
        if(StringUtils.equals("user",type)){
            trainings = trainingService.findUserTrainings(status,email);
        }else{
            trainings = trainingService.findMentorTrainings(status,email);
        }
        return ResponseEntity.ok(trainings);
    }

    @PostMapping("/book/{id}/{email}")
    public ResponseEntity<String> bookTraining(@PathVariable("id") String id
            ,@PathVariable("email") String email) {
        String msg = trainingService.bookTraining(id,email);
        return ResponseEntity.ok(msg);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addTraining(@RequestBody TTraining tTraining) {
        String msg = trainingService.addTraining(tTraining);
        return ResponseEntity.ok(msg);
    }

    @PostMapping("/deactivate/{id}")
    public ResponseEntity<String> deactivateTraining(@PathVariable("id") String id) {
        String msg = trainingService.deactivateTraining(id);
        return ResponseEntity.ok(msg);
    }
}
