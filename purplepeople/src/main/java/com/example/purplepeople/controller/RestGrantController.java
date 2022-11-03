package com.example.purplepeople.controller;

import com.example.purplepeople.domain.Cause;
import com.example.purplepeople.domain.Grant;
import com.example.purplepeople.mapper.CauseMapper;
import com.example.purplepeople.mapper.GrantMapper;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import purple.common.controller.CommonRestControllerPrototype;

@RestController
@RequestMapping("/api/grant")
public class RestGrantController extends CommonRestControllerPrototype {
    @Autowired
    private GrantMapper grantMapper;

    @PostMapping("/create")
    @ApiOperation("허가 여부 생성")
    public void CreateSchedule(
            @RequestBody
            Grant grant) {
        grantMapper.register(grant);
    }
    @PostMapping("/delete")
    @ApiOperation("허가 여부 제거")
    public void DeleteSchedule(
            @RequestBody
            Grant grant) {
        grantMapper.delete(grant.getIdx());
    }
}
