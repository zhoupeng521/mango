package com.zp.mango.mapper;

import com.zp.mango.model.SysConfig;
import java.util.List;

public interface SysConfigMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysConfig record);

    SysConfig selectByPrimaryKey(Long id);

    List<SysConfig> selectAll();

    int updateByPrimaryKey(SysConfig record);
}