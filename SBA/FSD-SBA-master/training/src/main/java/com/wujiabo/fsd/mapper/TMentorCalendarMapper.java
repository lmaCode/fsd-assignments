package com.lipengwei.fsd.mapper;

import com.lipengwei.fsd.entity.TMentorCalendar;
import com.lipengwei.fsd.entity.TMentorCalendarCriteria;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

@Mapper
public interface TMentorCalendarMapper {
    long countByExample(TMentorCalendarCriteria example);

    int deleteByExample(TMentorCalendarCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TMentorCalendar record);

    int insertSelective(TMentorCalendar record);

    List<TMentorCalendar> selectByExampleWithRowbounds(TMentorCalendarCriteria example, RowBounds rowBounds);

    List<TMentorCalendar> selectByExample(TMentorCalendarCriteria example);

    TMentorCalendar selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TMentorCalendar record, @Param("example") TMentorCalendarCriteria example);

    int updateByExample(@Param("record") TMentorCalendar record, @Param("example") TMentorCalendarCriteria example);

    int updateByPrimaryKeySelective(TMentorCalendar record);

    int updateByPrimaryKey(TMentorCalendar record);
}