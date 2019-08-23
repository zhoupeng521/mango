package com.zp.mango.mapper;

import com.zp.mango.model.SysConfig;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 添加了@Mapper注解之后这个接口在编译时会生成相应的实现类
 * 从mybatis3.4.0开始加入了@Mapper注解
 * 目的就是为了不再写mapper映射文件
 */
//@Mapper
@Repository
public interface SysConfigMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysConfig record);

    SysConfig selectByPrimaryKey(Long id);

    List<SysConfig> selectAll();

    int updateByPrimaryKey(SysConfig record);
}