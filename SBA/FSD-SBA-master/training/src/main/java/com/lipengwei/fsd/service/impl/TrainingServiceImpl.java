package com.lipengwei.fsd.service.impl;

import com.lipengwei.fsd.dto.TTechnology;
import com.lipengwei.fsd.dto.TUser;
import com.lipengwei.fsd.entity.TTraining;
import com.lipengwei.fsd.entity.TTrainingCriteria;
import com.lipengwei.fsd.entity.TUserTraining;
import com.lipengwei.fsd.entity.TUserTrainingCriteria;
import com.lipengwei.fsd.feign.TechnologyFeign;
import com.lipengwei.fsd.feign.UserFeign;
import com.lipengwei.fsd.mapper.TTrainingMapper;
import com.lipengwei.fsd.mapper.TUserTrainingMapper;
import com.lipengwei.fsd.service.TrainingService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class TrainingServiceImpl implements TrainingService {
    @Autowired
    private TTrainingMapper tTrainingMapper;
    @Autowired
    private TUserTrainingMapper tUserTrainingMapper;
    @Autowired
    private UserFeign userFeign;
    @Autowired
    private TechnologyFeign technologyFeign;
    @Override
    public List<TTraining> findAllTrainings() {
        TTrainingCriteria example = new TTrainingCriteria();
        return tTrainingMapper.selectByExample(example);
    }

    @Override
    public List<TTraining> findEnableTrainings() {
        TTrainingCriteria example = new TTrainingCriteria();
        example.createCriteria().andStatusNotEqualTo("completed");
        return tTrainingMapper.selectByExample(example);
    }

    @Override
    public List<TTraining> findUserTrainings(String status, String email) {
        TUserTrainingCriteria userExample = new TUserTrainingCriteria();
        userExample.createCriteria().andUserNameEqualTo(email).andStatusEqualTo(status);
        List<TUserTraining> tUserTrainings = tUserTrainingMapper.selectByExample(userExample);
        List<String> trainingIds = tUserTrainings.stream().map(tUserTraining -> tUserTraining.getTrainingId()).collect(Collectors.toList());
        if(CollectionUtils.isEmpty(trainingIds)){
            return Collections.EMPTY_LIST;
        }
        TTrainingCriteria example = new TTrainingCriteria();
        example.createCriteria().andIdIn(trainingIds);
        List<TTraining> tTrainings = tTrainingMapper.selectByExample(example);
        return tTrainings;
    }


    @Override
    public List<TTraining> findMentorTrainings(String status, String email) {
        TTrainingCriteria example = new TTrainingCriteria();
        example.createCriteria().andMentorNameEqualTo(email).andStatusEqualTo(status);
        List<TTraining> tTrainings = tTrainingMapper.selectByExample(example);
        return tTrainings;
    }

    @Override
    @Transactional
    public String bookTraining(String id, String email) {
        TUserTrainingCriteria userExample = new TUserTrainingCriteria();
        userExample.createCriteria().andUserNameEqualTo(email).andTrainingIdEqualTo(id);
        List<TUserTraining> tUserTrainings = tUserTrainingMapper.selectByExample(userExample);
        if(!CollectionUtils.isEmpty(tUserTrainings)){
            return "training is already booked";
        }
        ResponseEntity<TUser> responseEntity = userFeign.findByEmail(email);
        TUser tUser = responseEntity.getBody();
        TTraining tTraining = tTrainingMapper.selectByPrimaryKey(id);

        TUserTraining tUserTraining = new TUserTraining();
        tUserTraining.setId(UUID.randomUUID().toString());
        tUserTraining.setTrainingId(tTraining.getId());
        tUserTraining.setMentorId(tTraining.getMentorId());
        tUserTraining.setMentorName(tTraining.getMentorName());
        tUserTraining.setStatus("going");
        tUserTraining.setUserId(tUser.getId());
        tUserTraining.setUserName(tUser.getEmail());
        tUserTrainingMapper.insertSelective(tUserTraining);
        return "booked success";
    }

    @Override
    @Transactional
    public String addTraining(TTraining tTraining) {

        ResponseEntity<TUser> responseEntity = userFeign.findByEmail(tTraining.getMentorName());
        TUser tUser = responseEntity.getBody();

        ResponseEntity<TTechnology> technologyResponseEntity = technologyFeign.findBySkillId(tTraining.getSkillId());
        TTechnology technology = technologyResponseEntity.getBody();

        tTraining.setId(UUID.randomUUID().toString());
        tTraining.setStatus("going");
        tTraining.setProgress(0);
        tTraining.setMentorId(tUser.getId());
        tTraining.setSkillName(technology.getSkillName());
        tTrainingMapper.insertSelective(tTraining);
        return "save success";
    }

    @Override
    @Transactional
    public String deactivateTraining(String id) {
        TTraining tTraining = new TTraining();
        tTraining.setId(id);
        tTraining.setStatus("deactivate");
        tTrainingMapper.updateByPrimaryKeySelective(tTraining);
        return "deactivate success";
    }
}
