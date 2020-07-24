package com.lipengwei.fsd.service.impl;

import com.lipengwei.fsd.entity.TTechnology;
import com.lipengwei.fsd.entity.TTechnologyCriteria;
import com.lipengwei.fsd.mapper.TTechnologyMapper;
import com.lipengwei.fsd.service.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class TechnologyServiceImpl implements TechnologyService {

    @Autowired
    private TTechnologyMapper tTechnologyMapper;

    @Override
    public List<TTechnology> findAllTechnologies() {
        TTechnologyCriteria example = new TTechnologyCriteria();
        return tTechnologyMapper.selectByExample(example);
    }

    @Override
    public TTechnology findBySkillId(String skillId) {
        TTechnologyCriteria example = new TTechnologyCriteria();
        example.createCriteria().andIdEqualTo(skillId);
        List<TTechnology> tTechnologies = tTechnologyMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(tTechnologies)){
            return null;
        }
        return tTechnologies.get(0);
    }
}
