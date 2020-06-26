package com.lipengwei.fsd.service;

import com.lipengwei.fsd.entity.TTraining;

import java.util.List;

public interface TrainingService {
    List<TTraining> findAllTrainings();

    List<TTraining> findEnableTrainings();

    List<TTraining> findUserTrainings(String status, String email);

    String bookTraining(String id, String email);

    List<TTraining> findMentorTrainings(String status, String email);

    String addTraining(TTraining tTraining);

    String deactivateTraining(String id);
}
