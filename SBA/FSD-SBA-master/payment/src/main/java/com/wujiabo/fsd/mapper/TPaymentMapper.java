package com.lipengwei.fsd.mapper;

import com.lipengwei.fsd.entity.TPayment;
import com.lipengwei.fsd.entity.TPaymentCriteria;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

@Mapper
public interface TPaymentMapper {
    long countByExample(TPaymentCriteria example);

    int deleteByExample(TPaymentCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(TPayment record);

    int insertSelective(TPayment record);

    List<TPayment> selectByExampleWithRowbounds(TPaymentCriteria example, RowBounds rowBounds);

    List<TPayment> selectByExample(TPaymentCriteria example);

    TPayment selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TPayment record, @Param("example") TPaymentCriteria example);

    int updateByExample(@Param("record") TPayment record, @Param("example") TPaymentCriteria example);

    int updateByPrimaryKeySelective(TPayment record);

    int updateByPrimaryKey(TPayment record);
}