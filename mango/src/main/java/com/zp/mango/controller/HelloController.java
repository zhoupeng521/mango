package com.zp.mango.controller;

import com.zp.mango.mapper.SysMenuMapper;
import com.zp.mango.model.SysMenu;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@Api(value = "爸爸接口",description = "爸爸接口")
public class HelloController {

    @Autowired
    private SysMenuMapper sysMenuMapper;

    @GetMapping("/sayHello")
    @ApiOperation("叫爸爸")
    public Map<String,Object> sayHello(){
        Map<String,Object> map = new HashMap<>();
        SysMenu sysMenu = sysMenuMapper.selectByPrimaryKey(1L);
        map.put("code","000000");
        map.put("data",sysMenu);
        map.put("msg","请求成功");
        return map;
    }

}
