package com.lipengwei.fsd.mapper;

import com.lipengwei.fsd.entity.TMentorSkill;
import com.lipengwei.fsd.entity.TMentorSkillCriteria;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

@Mapper
public interface TMentorSkillMapper {
    long countByExample(TMentorSkillCriteria example);

    int deleteByExample(TMentorSkillCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TMentorSkill record);

    int insertSelective(TMentorSkill record);

    List<TMentorSkill> selectByExampleWithRowbounds(TMentorSkillCriteria example, RowBounds rowBounds);

    List<TMentorSkill> selectByExample(TMentorSkillCriteria example);

    TMentorSkill selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TMentorSkill record, @Param("example") TMentorSkillCriteria example);

    int updateByExample(@Param("record") TMentorSkill record, @Param("example") TMentorSkillCriteria example);

    int updateByPrimaryKeySelective(TMentorSkill record);

    int updateByPrimaryKey(TMentorSkill record);
}