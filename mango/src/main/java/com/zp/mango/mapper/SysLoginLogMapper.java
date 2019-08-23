package com.zp.mango.mapper;

import com.zp.mango.model.SysLoginLog;
import java.util.List;

public interface SysLoginLogMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysLoginLog record);

    SysLoginLog selectByPrimaryKey(Long id);

    List<SysLoginLog> selectAll();

    int updateByPrimaryKey(SysLoginLog record);
}