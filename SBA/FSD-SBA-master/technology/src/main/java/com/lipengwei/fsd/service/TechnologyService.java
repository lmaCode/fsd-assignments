package com.lipengwei.fsd.service;

import com.lipengwei.fsd.entity.TTechnology;

import java.util.List;

public interface TechnologyService {
    List<TTechnology> findAllTechnologies();

    TTechnology findBySkillId(String skillId);
}
