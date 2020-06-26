package com.lipengwei.fsd.mapper;

import com.lipengwei.fsd.entity.TTraining;
import com.lipengwei.fsd.entity.TTrainingCriteria;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

@Mapper
public interface TTrainingMapper {
    long countByExample(TTrainingCriteria example);

    int deleteByExample(TTrainingCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TTraining record);

    int insertSelective(TTraining record);

    List<TTraining> selectByExampleWithRowbounds(TTrainingCriteria example, RowBounds rowBounds);

    List<TTraining> selectByExample(TTrainingCriteria example);

    TTraining selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TTraining record, @Param("example") TTrainingCriteria example);

    int updateByExample(@Param("record") TTraining record, @Param("example") TTrainingCriteria example);

    int updateByPrimaryKeySelective(TTraining record);

    int updateByPrimaryKey(TTraining record);
}