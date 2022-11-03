package com.example.purplepeople.controller;

import com.example.purplepeople.domain.Cause;
import com.example.purplepeople.domain.Schedule;
import com.example.purplepeople.mapper.CauseMapper;
import com.example.purplepeople.mapper.ScheduleMapper;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import purple.common.controller.CommonRestControllerPrototype;

@RestController
@RequestMapping("/api/cause")
public class RestCauseController extends CommonRestControllerPrototype {
    @Autowired
    private CauseMapper causeMapper;

    @PostMapping("/create")
    @ApiOperation("사유 생성")
    public void CreateSchedule(
            @RequestBody
            Cause cause) {
        causeMapper.register(cause);
    }
    @PostMapping("/delete")
    @ApiOperation("사유 제거")
    public void DeleteSchedule(
            @RequestBody
            Cause cause) {
        causeMapper.delete(cause.getIdx());
    }
}
