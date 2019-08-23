package com.zp.mango.mapper;

import com.zp.mango.model.SysDic;
import java.util.List;

public interface SysDicMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysDic record);

    SysDic selectByPrimaryKey(Long id);

    List<SysDic> selectAll();

    int updateByPrimaryKey(SysDic record);
}