package com.zp.mango.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;

@RestController
@Api(value = "爸爸接口",description = "爸爸接口")
public class HelloController {

    @GetMapping("/sayHello")
    @ApiOperation("叫爸爸")
    public String sayHello(){
        return "I'm 你爸爸";
    }

}
