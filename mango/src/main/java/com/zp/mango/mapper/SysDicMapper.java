package com.zp.mango.mapper;

import com.zp.mango.model.SysDic;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Mapper
@Repository
public interface SysDicMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysDic record);

    SysDic selectByPrimaryKey(Long id);

    List<SysDic> selectAll();

    int updateByPrimaryKey(SysDic record);
}