package com.lipengwei.fsd.mapper;

import com.lipengwei.fsd.entity.TTechnology;
import com.lipengwei.fsd.entity.TTechnologyCriteria;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

@Mapper
public interface TTechnologyMapper {
    long countByExample(TTechnologyCriteria example);

    int deleteByExample(TTechnologyCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TTechnology record);

    int insertSelective(TTechnology record);

    List<TTechnology> selectByExampleWithRowbounds(TTechnologyCriteria example, RowBounds rowBounds);

    List<TTechnology> selectByExample(TTechnologyCriteria example);

    TTechnology selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TTechnology record, @Param("example") TTechnologyCriteria example);

    int updateByExample(@Param("record") TTechnology record, @Param("example") TTechnologyCriteria example);

    int updateByPrimaryKeySelective(TTechnology record);

    int updateByPrimaryKey(TTechnology record);
}