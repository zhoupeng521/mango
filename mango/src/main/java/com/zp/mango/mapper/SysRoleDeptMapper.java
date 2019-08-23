package com.zp.mango.mapper;

import com.zp.mango.model.SysRoleDept;
import java.util.List;

public interface SysRoleDeptMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysRoleDept record);

    SysRoleDept selectByPrimaryKey(Long id);

    List<SysRoleDept> selectAll();

    int updateByPrimaryKey(SysRoleDept record);
}